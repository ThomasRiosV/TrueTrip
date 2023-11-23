package backend.project.servicesimpl;

import backend.project.entities.PostCategory;
import backend.project.entities.TravelCategory;
import backend.project.entities.TravelPost;
import backend.project.repositories.PostCategoryRepository;
import backend.project.services.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

    @Autowired
    PostCategoryRepository postCategoryRepository;


    @Override
    public void assignCategoriesToTravelPost(TravelPost travelPost, List<TravelCategory> categories) {

        for (TravelCategory category : categories) {
            PostCategory postCategory = new PostCategory();
            postCategory.setTravelPost(travelPost);
            postCategory.setTravelCategory(category);
            postCategoryRepository.save(postCategory);
        }
    }
}
