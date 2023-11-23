package backend.project.services;

import backend.project.entities.TravelCategory;
import backend.project.entities.TravelPost;

import java.util.List;

public interface PostCategoryService {

    public void assignCategoriesToTravelPost(TravelPost travelPost, List<TravelCategory> categories);

}
