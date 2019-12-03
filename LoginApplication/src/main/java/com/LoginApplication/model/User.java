package com.LoginApplication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "logintable")
public class User implements Serializable {
	@Id
	@Column(name = "userid", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "UserId cannot be blank")
	private int userId;
	@NotNull(message="username cannot be null")
	@Size(min=5,message="USERNAME SHOULD BE 5 OR MORE CHARACTERS")
	@Column(name = "username", length = 10)
	private String userName;
	@NotNull(message="password cannot be null")
	//@Min(value = 5, message = "PASSWORD SHOULD BE 5 OR MORE CHARACTERS")
	@Column(name = "password", length = 10)
	private String password;

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
