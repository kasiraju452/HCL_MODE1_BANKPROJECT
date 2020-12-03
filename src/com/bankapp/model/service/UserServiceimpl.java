package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.UserDao;
import com.bankapp.model.entities.User;

@Service
@Transactional
public class UserServiceimpl implements UserService{
	
private UserDao userDao;
	
	@Autowired
	public UserServiceimpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUsers() {
	
		return userDao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	@Override
	public User deleteUser(User user) {
		
		return (User) userDao.deleteUser(user);
	}

	@Override
	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		
		return userDao.getUser(username, password);
	}

	@Override
	public User getUserById(int accountId) {
		return userDao.getUserById(accountId);
				
	}

	/*@Override
	public User deleteUser(User user) {
		return userDao.deleteUser(user);
		
	}*/
	
	
	
	
	
}
