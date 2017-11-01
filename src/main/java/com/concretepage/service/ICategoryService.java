package com.concretepage.service;

import com.concretepage.entity.Category;

import java.util.List;

public interface ICategoryService {
     List<Category> getAllCategories();
     Category getCategoryById(int categoryId);
     boolean addCategory(Category category);
     void updateCategory(Category category);
     void deleteCategory(int categoryId);
}
