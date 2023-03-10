package com.mtshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mtshop.dto.CategoryDto;
import com.mtshop.exception.ResourceNotFoundException;

@Service
public interface CategoryService {

	CategoryDto save(CategoryDto categoryDto) throws Exception;

	CategoryDto findCategoryById(long id);

	List<CategoryDto> findAll();

	Map<String, String> deleteCategory(long[] ids);

	Map<String, String> deleteSoftCategory(long[] ids) throws ResourceNotFoundException;

}
