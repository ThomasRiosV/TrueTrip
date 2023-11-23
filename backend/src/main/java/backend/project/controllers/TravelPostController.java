package backend.project.controllers;

import backend.project.entities.TravelPost;
import backend.project.services.TravelPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TravelPostController {

    @Autowired
    TravelPostService travelPostService;

    @PostMapping("/travelpost")
    public ResponseEntity<TravelPost> createTravelPost(@RequestBody TravelPost travelPost) {
        TravelPost createdTravelPost = travelPostService.createTravelPost(travelPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTravelPost);
    }

    @PutMapping("/travelpost/{id}")
    public ResponseEntity<TravelPost> updateTravelPost(@PathVariable Long id, @RequestBody TravelPost updatedTravelPost) {
        TravelPost updatedPost = travelPostService.updateTravelPost(id, updatedTravelPost);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/travelpost/delete/{id}")
    public ResponseEntity<Void> deleteTravelPost(@PathVariable Long id) {
        boolean deleted = travelPostService.deleteTravelPost(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/travelpost/detalle/{id}")
    public ResponseEntity<TravelPost> getTravelPostDetails(@PathVariable Long id) {
        TravelPost travelPost = travelPostService.getTravelPostDetails(id);
        if (travelPost != null) {
            return ResponseEntity.ok(travelPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/travelpost/all")
    public ResponseEntity<List<TravelPost>> getAllTravelPosts() {
        List<TravelPost> travelPosts = travelPostService.getAllTravelPosts();
        return ResponseEntity.ok(travelPosts);
    }

    @GetMapping("/travelpost/search")
    public ResponseEntity<List<TravelPost>> searchTravelPosts(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
            @RequestParam(required = false) Double cost) {
        List<TravelPost> filteredTravelPosts = travelPostService.searchTravelPosts(destination, startDate, endDate, cost);
        return ResponseEntity.ok(filteredTravelPosts);
    }


}
