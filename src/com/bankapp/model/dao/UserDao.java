package com.bankapp.model.dao;

import java.util.List;
import com.bankapp.model.entities.*;
public interface UserDao {

	public List<User> getAllUsers();
	public User updateUser(User user);
	public User deleteUser(String username,String password);
	public User getUserById(int uId);
	public User addUser(User user);
	public User getUser(String username, String password);
	public Object deleteUser(User user);
	

	/*public List<User> getAllUsers();
	public User addUser(User user);
	public User deleteUser(User user);
	public User updateUser(int uid, User user);
	public User getUser(String username);
	public User getUserDetails(String username, String password);
	public User getUserById(int accountId);*/
}
