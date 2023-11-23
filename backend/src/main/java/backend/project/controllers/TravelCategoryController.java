package backend.project.controllers;

import backend.project.entities.TravelCategory;
import backend.project.services.TravelCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/travel-categories")
public class TravelCategoryController {

    @Autowired
    TravelCategoryService travelCategoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody TravelCategory category) {
        // Implementa el endpoint para crear una nueva categoría
        TravelCategory createdCategory = travelCategoryService.createCategory(category);
        if (createdCategory != null) {
            return ResponseEntity.ok(createdCategory);
        } else {
            return ResponseEntity.badRequest().body("No se pudo crear la categoría.");
        }
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<?> updateCategory(
            @PathVariable Long categoryId, @RequestBody TravelCategory updatedCategory) {
        // Implementa el endpoint para editar una categoría existente
        TravelCategory updated = travelCategoryService.updateCategory(categoryId, updatedCategory);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.badRequest().body("No se pudo actualizar la categoría.");
        }
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        // Implementa el endpoint para eliminar una categoría por su ID
        if (travelCategoryService.deleteCategory(categoryId)) {
            return ResponseEntity.ok("Categoría eliminada correctamente.");
        } else {
            return ResponseEntity.badRequest().body("No se pudo eliminar la categoría.");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<TravelCategory>> getAllCategories() {
        // Implementa el endpoint para listar todas las categorías disponibles
        List<TravelCategory> categories = travelCategoryService.getAllTravelCategories();
        return ResponseEntity.ok(categories);
    }

  @GetMapping("/{id}")
  public ResponseEntity<TravelCategory> getAEmployeeById(@PathVariable("id") Long id) {
    TravelCategory employee = travelCategoryService.findById(id);
    return new ResponseEntity<TravelCategory>(employee, HttpStatus.OK);
  }
}
