package com.LoginApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LoginApplication.exception.UserNotFoundException;
import com.LoginApplication.model.User;
import com.LoginApplication.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository loginRepository;

	@Override
	@Transactional
	public User createUser(User user) {

		if (user.getUserId() != 0) {
			if (user.getPassword().length() > 5) {
				this.loginRepository.save(user);
				return user;
			} else {
				throw new UserNotFoundException(
						"Password entered is leass than 5 characters      " + user.getPassword());
			}

		} else {
			throw new UserNotFoundException("User is invalid");

		}

	}

	@Override
	public User readUserByName(String userName) {

		return this.loginRepository.findByUserName(userName);
	}

	@Override
	public User readUserById(int userId) {

		return this.loginRepository.findByUserId(userId);
	}

	@Override
	public List<User> findAll() {

		return this.loginRepository.findAll();
	}

	@Override
	@Transactional
	public User updateUserName(int userId, String userName) {
		int updatedrows = this.loginRepository.updateUserName(userId, userName);
		if (updatedrows != 0) {
			return this.loginRepository.findByUserId(userId);
		} else {
			throw new UserNotFoundException("Entered userId is invalid");
		}
	}

	@Override
	@Transactional
	public User updateUserPassword(int userId, String password) {
		int updatedrows = this.loginRepository.updatePassword(userId, password);
		if (updatedrows != 0) {
			return this.readUserById(userId);
		} else {
			throw new UserNotFoundException("Entered userId is invalid");
		}

	}

	@Override
	@Transactional
	public User deleteUserById(int userId) {
		User user = this.loginRepository.findByUserId(userId);
		int deletedrows = this.loginRepository.deleteUserById(userId);
		if (deletedrows != 0) {
			return user;
		} else {
			throw new UserNotFoundException("Entered userId is invalid check it once" + user.getUserId());
		}

	}

	@Override
	@Transactional
	public User deleteUserByUserName(String userName) {
		User user = this.loginRepository.findByUserName(userName);
		int deletedrows = this.loginRepository.deleteUserByUsername(userName);
		if (deletedrows != 0) {
			return user;
		} else {
			throw new UserNotFoundException("Entered userName is invalid and check it" + user.getUserName());
		}
	}

}
