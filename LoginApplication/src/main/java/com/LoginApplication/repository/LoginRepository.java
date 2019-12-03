package com.LoginApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.LoginApplication.model.User;

public interface LoginRepository extends CrudRepository<User, Integer> {
	public User findByUserName(String userName);

	public User findByUserId(int userId);

	public List<User> findAll();

	@Modifying
	@Query("update User user1 set user1.userName=:username where user1.userId=:userid")
	public int updateUserName(@Param("userid") int userId, @Param("username") String userName);

	@Modifying
	@Query("update User user1 set user1.password=:password where user1.userId=:userid")
	public int updatePassword(@Param("userid") int userId, @Param("password") String password);

	@Modifying
	@Query("delete User user1 where user1.userId=:userid")
	public int deleteUserById(@Param("userid") int userId);

	@Modifying
	@Query("delete User user1 where user1.userName=:username")
	public int deleteUserByUsername(@Param("username") String userName);
}
