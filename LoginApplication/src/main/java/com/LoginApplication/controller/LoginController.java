package com.LoginApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.LoginApplication.model.User;
import com.LoginApplication.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/createuser")
	public User createUser(@Valid @RequestBody User user) {
		return this.loginService.createUser(user);
	}

	@GetMapping("/readbyname/{userName}")
	public User readUserByName(@PathVariable("userName") String userName) {
		return this.loginService.readUserByName(userName);
	}

	@GetMapping("/readbyid/{userId}")
	public User readUserById(@PathVariable("userId") int userId) {
		return this.loginService.readUserById(userId);
	}

	@GetMapping("/readall")
	public List<User> readAllUsers() {
		return this.loginService.findAll();
	}

	@PutMapping("/updateusername/{userid}/{username}")
	public User updateUserName(@PathVariable("userid") int userId, @PathVariable("username") String userName) {
		return this.loginService.updateUserName(userId, userName);
	}

	@PutMapping("/updatepassword/{userid}/{password}")
	public User updatePassword(@PathVariable("userid") int userId, @PathVariable("password") String password) {
		return this.loginService.updateUserPassword(userId, password);
	}

	@DeleteMapping("/deleteuserbyid/{userid}")
	public User deleteUserById(@PathVariable("userid") int userId) {
		return this.loginService.deleteUserById(userId);
	}

	@DeleteMapping("/deleteuserbyname/{username}")
	public User deleteUserByUserName(@PathVariable("username") String userName) {
		return this.loginService.deleteUserByUserName(userName);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}
}
