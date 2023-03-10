package com.mtshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtshop.dto.CategoryDto;
import com.mtshop.exception.ResourceNotFoundException;
import com.mtshop.service.CategoryService;

@RestController
@RequestMapping("/api/v1/")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categorise")
	public List<CategoryDto> findAll() {
		return categoryService.findAll();
	}
	
	@GetMapping("/categorise/{id}") 
	public CategoryDto findCategoryById(@PathVariable long id) {
		return categoryService.findCategoryById(id);
	}
	
	@PostMapping("categorise")
	public CategoryDto createCategory (@RequestBody CategoryDto categoryDto) throws Exception {
		return categoryService.save(categoryDto);
	}
	
	@PutMapping("/categorise/{id}") 
	public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable long id) throws Exception {
		categoryDto.setId(id);
		return categoryService.save(categoryDto);
	}
	
	@DeleteMapping("/categorise")
	public ResponseEntity<Map<String, String>> deleteCategory(@RequestBody long[] ids) {
		return ResponseEntity.ok(categoryService.deleteCategory(ids));
	}
	
	@PutMapping("/categorise")
	ResponseEntity<Map<String, String>> deleteSoftCategory(@RequestBody long[] ids) throws ResourceNotFoundException {
		return ResponseEntity.ok(categoryService.deleteSoftCategory(ids));
	} 
}
