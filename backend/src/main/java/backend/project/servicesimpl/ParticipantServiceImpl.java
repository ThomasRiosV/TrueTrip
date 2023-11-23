package backend.project.servicesimpl;

import backend.project.entities.Participant;
import backend.project.entities.TravelPost;
import backend.project.entities.User;
import backend.project.repositories.ParticipantRepository;
import backend.project.repositories.TravelPostRepository;
import backend.project.repositories.UserRepository;
import backend.project.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;
    TravelPostRepository travelPostRepository;
    UserRepository userRepository;

    @Override
    public boolean joinTravelPost(Long travelPostId, String username) {
        // Buscar el usuario por nombre de usuario
        User user = userRepository.findByUserName(username);
        // Buscar la publicación de viaje por su ID
        Optional<TravelPost> travelPostOptional = travelPostRepository.findById(travelPostId);

        if (user != null && travelPostOptional.isPresent()) {
            TravelPost travelPost = travelPostOptional.get();

            // Realizar las validaciones necesarias antes de unirse al viaje
            // Puedes verificar si el usuario ya es un participante, si el viaje tiene espacio disponible, etc.
            boolean isParticipant = user.getParticipants()
                    .stream()
                    .anyMatch(participant -> participant.getTravelPost().equals(travelPost));

            if (!isParticipant) {
                // Crear una nueva relación entre el usuario y el viaje
                Participant participant = new Participant(user, travelPost);
                user.getParticipants().add(participant);
                userRepository.save(user);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean cancelParticipation(Long travelPostId, String username) {
        // Buscar el usuario por nombre de usuario
        User user = userRepository.findByUserName(username); // Buscar la publicación de viaje por su ID
        Optional<TravelPost> travelPostOptional = travelPostRepository.findById(travelPostId);

        if (user != null && travelPostOptional.isPresent()) {
            TravelPost travelPost = travelPostOptional.get();

            // Realizar las validaciones necesarias antes de cancelar la participación
            // Por ejemplo, puedes verificar si el usuario es un participante del viaje, etc.
            boolean isParticipant = user.getParticipants()
                    .stream()
                    .anyMatch(participant -> participant.getTravelPost().equals(travelPost));

            if (isParticipant) {
                // Elimina la relación entre el usuario y el viaje
                user.getParticipants().removeIf(participant -> participant.getTravelPost().getId().equals(travelPostId));
                userRepository.save(user);
                return true;
            }
        }

        return false;
    }
    @Override
    public List<User> getParticipantsForTravelPost(Long travelPostId) {
        // Implementa la lógica para obtener la lista de participantes en un viaje
        Optional<TravelPost> travelPostOptional = travelPostRepository.findById(travelPostId);

        if (travelPostOptional.isPresent()) {
            TravelPost travelPost = travelPostOptional.get();
            List<Participant> participants = travelPost.getParticipants();

            List<User> participantUsers = participants.stream()
                    .map(Participant::getUser)
                    .collect(Collectors.toList());

            return participantUsers;
        }

        return new ArrayList<>();
    }
}
