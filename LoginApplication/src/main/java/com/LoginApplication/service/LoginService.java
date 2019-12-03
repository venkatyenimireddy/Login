package com.LoginApplication.service;

import java.util.List;

import com.LoginApplication.model.User;

public interface LoginService {
	public abstract User createUser(User user);

	public abstract User readUserByName(String userName);

	public abstract User readUserById(int userId);

	public abstract List<User> findAll();

	public abstract User updateUserName(int userId, String userName);

	public abstract User updateUserPassword(int userId, String password);

	public abstract User deleteUserById(int userId);

	public abstract User deleteUserByUserName(String userName);
}
