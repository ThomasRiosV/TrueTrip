package backend.project.controllers;

import backend.project.entities.User;
import backend.project.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;


    @PostMapping("/join/{travelPostId}")
    public ResponseEntity<String> joinTravelPost(@PathVariable Long travelPostId, @RequestParam String username) {
        // Implementa la lógica para permitir que un usuario se una a un viaje (travelPostId)
        if (participantService.joinTravelPost(travelPostId, username)) {
            return ResponseEntity.ok("Te has unido al viaje correctamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo unir al viaje.");
        }
    }

    @PostMapping("/cancel/{travelPostId}")
    public ResponseEntity<String> cancelParticipation(
            @PathVariable Long travelPostId,
            @RequestParam String username
    ) {
        // Implementa la lógica para permitir que un usuario cancele su participación en un viaje (travelPostId)
        boolean canceled = participantService.cancelParticipation(travelPostId, username);

        if (canceled) {
            return ResponseEntity.ok("Has cancelado tu participación en el viaje.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo cancelar la participación en el viaje.");
        }
    }

    @GetMapping("/participants/{travelPostId}")
    public ResponseEntity<List<User>> getParticipantsForTravelPost(@PathVariable Long travelPostId) {
        // Llama al servicio para obtener la lista de participantes en un viaje
        List<User> participants = participantService.getParticipantsForTravelPost(travelPostId);

        // Devuelve la lista de participantes como respuesta HTTP
        return ResponseEntity.ok(participants);
    }
}