package backend.project.servicesimpl;

import backend.project.entities.TravelCategory;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.TravelCategoryRepository;
import backend.project.services.TravelCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelCategoryServiceImpl implements TravelCategoryService {

  @Autowired
  TravelCategoryRepository travelCategoryRepository;

  @Override
  public TravelCategory findById(Long id) {
    TravelCategory employeeFound = travelCategoryRepository.findById(id).orElse(null);
    if (employeeFound == null) {
      throw new ResourceNotFoundException("There are no Employee with the id: "+String.valueOf(id));
    }
    return employeeFound;
  }

  @Override
  public List<TravelCategory> getAllTravelCategories() {
    return travelCategoryRepository.findAll();
  }

  @Override
  public TravelCategory createCategory(TravelCategory category) {
    return travelCategoryRepository.save(category);
  }

  @Override
  public TravelCategory updateCategory(Long categoryId, TravelCategory updatedCategory) {
    Optional<TravelCategory> existingCategory = travelCategoryRepository.findById(categoryId);
    if (existingCategory.isPresent()) {
      TravelCategory category = existingCategory.get();
      // Actualiza los detalles de la categoría con los datos de 'updatedCategory'
      category.setName(updatedCategory.getName());
      return travelCategoryRepository.save(category);
    }
    return null;
  }

  @Override
  public boolean deleteCategory(Long categoryId) {
    if (travelCategoryRepository.existsById(categoryId)) {
      travelCategoryRepository.deleteById(categoryId);
      return true;
    }
    return false;
  }
}
