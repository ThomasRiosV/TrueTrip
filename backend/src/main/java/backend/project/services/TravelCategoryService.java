package backend.project.services;

import backend.project.entities.TravelCategory;

import java.util.List;

public interface TravelCategoryService {


  public List<TravelCategory> getAllTravelCategories();

  public TravelCategory createCategory(TravelCategory category);

  public TravelCategory updateCategory(Long categoryId, TravelCategory updatedCategory);

  public boolean deleteCategory(Long categoryId);

  public TravelCategory findById(Long id);
}
