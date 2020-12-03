package com.bankapp.model.dao.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.entities.User;

@Repository
public class UserDaoimpl implements UserDao {
private SessionFactory factory;
	
	@Autowired
	public UserDaoimpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<User> getAllUsers() {
		return getSession().createQuery("from User").getResultList();
	}

	@Override
	public User addUser(User user) {
		getSession().save(user);
		return user;
	}

	@Override
	public User deleteUser(String username,String password) {
		User userToBeDeleted=getUser(username, password);
		getSession().delete(userToBeDeleted);
		return userToBeDeleted;
	}

	@Override
	public User updateUser(User user) {
		User userToBeUpdated = getUser(user.getUsername(), user.getPassword());
		getSession().update(user);
		return user;
	}

	@Override
	public User getUser(String username, String password) {
		org.hibernate.query.Query query = getSession().createQuery("from User where username=:username1 and password=:password1");
		query.setParameter("username1", username);
		query.setParameter("password1", password);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public User getUserById(int uId) {
		User user = getSession().get(User.class, uId);
		return user;
	}
	@Override
	public User deleteUser(User user) {
		User userToBeDeleted = getUserById(user.getUid());
		getSession().delete(userToBeDeleted);
		return userToBeDeleted;
	}
	//111111111111111111111111111111111111111111111111111111111111111
}
