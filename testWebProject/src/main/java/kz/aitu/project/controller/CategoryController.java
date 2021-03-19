package kz.aitu.project.controller;

import kz.aitu.project.entity.Category;
import kz.aitu.project.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/api/categories/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable long categoryId){
        return ResponseEntity.ok(categoryService.getById(categoryId));
    }

    @PostMapping("/api/categories")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.create(category));
    }

    @PutMapping("/api/categories/{categoryId}")
    public ResponseEntity<?> updateCategoryById(@RequestBody Category category, @PathVariable long categoryId){
        return ResponseEntity.ok(categoryService.updateById(category, categoryId));
    }

    @DeleteMapping("/api/categories/{categoryId}")
    public void deleteCategoryById(@PathVariable long categoryId){
        categoryService.deleteById(categoryId);
    }
}
