package com.concretepage.service;

import com.concretepage.dao.ICategoryDAO;
import com.concretepage.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private ICategoryDAO categoryDAO;
	@Override
	public Category getCategoryById(int categoryId) {
		Category obj = categoryDAO.getCategoryById(categoryId);
		return obj;
	}	
	@Override
	public List<Category> getAllCategories(){
		return categoryDAO.getAllCategories();
	}
	@Override
	public synchronized boolean addCategory(Category category){
       if (categoryDAO.categoryExists(category.getName())) {
    	   return false;
       } else {
		   categoryDAO.addCategory(category);
    	   return true;
       }
	}
	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}
	@Override
	public void deleteCategory(int categoryId) {
		categoryDAO.deleteCategory(categoryId);
	}
}
