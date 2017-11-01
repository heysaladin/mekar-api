package com.concretepage.controller;

import com.concretepage.entity.Category;
import com.concretepage.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("user")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	@GetMapping("category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
		Category category = categoryService.getCategoryById(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	@GetMapping("categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> list = categoryService.getAllCategories();
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	@PostMapping("category")
	public ResponseEntity<Void> addCategory(@RequestBody Category category, UriComponentsBuilder builder) {
        boolean flag = categoryService.addCategory(category);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/category/{id}").buildAndExpand(category.getCategoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("category")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	@DeleteMapping("category/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 