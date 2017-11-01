package com.concretepage.dao;

import com.concretepage.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CategoryDAO implements ICategoryDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Category getCategoryById(int categoryId) {
		return entityManager.find(Category.class, categoryId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		String hql = "FROM Category as ctgr ORDER BY ctgr.categoryId";
		return (List<Category>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
	}
	@Override
	public void updateCategory(Category category) {
		Category ctgr = getCategoryById(category.getCategoryId());
		ctgr.setName(category.getName());
		entityManager.flush();
	}
	@Override
	public void deleteCategory(int categoryId) {
		entityManager.remove(getCategoryById(categoryId));
	}
	@Override
	public boolean categoryExists(String name) {
		String hql = "FROM Category as ctgr WHERE ctgr.name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
