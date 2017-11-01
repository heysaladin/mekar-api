package com.concretepage.dao;

import com.concretepage.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
    boolean categoryExists(String name);
}
 