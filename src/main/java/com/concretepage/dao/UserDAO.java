package com.concretepage.dao;

import com.concretepage.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public User getUserById(int userId) {
		return entityManager.find(User.class, userId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as user ORDER BY user.userId";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}
	@Override
	public void updateUser(User user) {
		User usr = getUserById(user.getUserId());
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setSex(user.getSex());
		entityManager.flush();
	}
	@Override
	public void deleteUser(int userId) {
		entityManager.remove(getUserById(userId));
	}
	@Override
	public boolean userExists(String firstName, String lastName, String sex) {
		String hql = "FROM User as user WHERE usr.firstName = ? and user.lastName = ? and user.sex = ?";
		int count = entityManager.createQuery(hql).setParameter(1, firstName)
				.setParameter(2, lastName).setParameter(3, sex).getResultList().size();
		return count > 0 ? true : false;
	}
}
