package backend.project.services;

import backend.project.entities.TravelPost;

import java.util.Date;
import java.util.List;

public interface TravelPostService {

    public TravelPost createTravelPost(TravelPost travelPost);

    public TravelPost updateTravelPost(Long id, TravelPost updatedTravelPost);

    public boolean deleteTravelPost(Long id);

    public TravelPost getTravelPostDetails(Long id);

    public List<TravelPost> getAllTravelPosts();

    public List<TravelPost> searchTravelPosts(String destination, Date startDate, Date endDate, Double cost);
}
