package backend.project.servicesimpl;

import backend.project.entities.TravelPost;
import backend.project.repositories.TravelPostRepository;
import backend.project.services.TravelPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TravelPostServiceImpl implements TravelPostService {

    @Autowired
    private TravelPostRepository travelPostRepository;

    @Override
    public TravelPost createTravelPost(TravelPost travelPost) {
        return travelPostRepository.save(travelPost);
    }

    @Override
    public TravelPost updateTravelPost(Long id, TravelPost updatedTravelPost) {
        Optional<TravelPost> existingTravelPost = travelPostRepository.findById(id);
        if (existingTravelPost.isPresent()) {
            TravelPost travelPost = existingTravelPost.get();
            // Actualiza los detalles del viaje con los datos de 'updatedTravelPost'
            travelPost.setTitle(updatedTravelPost.getTitle());
            travelPost.setDescription(updatedTravelPost.getDescription());
            travelPost.setStartDate(updatedTravelPost.getStartDate());
            travelPost.setEndDate(updatedTravelPost.getEndDate());
            travelPost.setDestination(updatedTravelPost.getDestination());
            travelPost.setCost(updatedTravelPost.getCost());
            travelPost.setMaxParticipants(updatedTravelPost.getMaxParticipants());
            // Guarda la actualización en el repositorio
            return travelPostRepository.save(travelPost);
        }
        return null;
    }

    @Override
    public boolean deleteTravelPost(Long id) {
        // Implementa la lógica para eliminar un viaje por su ID
        if (travelPostRepository.existsById(id)) {
            travelPostRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public TravelPost getTravelPostDetails(Long id) {
        return travelPostRepository.findById(id).orElse(null);
    }

    @Override
    public List<TravelPost> getAllTravelPosts() {
        return travelPostRepository.findAll();
    }

    @Override
    public List<TravelPost> searchTravelPosts(String destination, Date startDate, Date endDate, Double cost) {
        return travelPostRepository.findTravelPostsByFilters(destination, startDate, endDate, cost);
    }
}
