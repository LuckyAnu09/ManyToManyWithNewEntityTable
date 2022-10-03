package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserRequestDto;
import com.example.dto.UserRoleBatchRequest;
import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@GetMapping("/user")
	public List<User> getAllUsers()
	{
		return us.getAllUsers();
	}
	
	@PostMapping("/user/role")
	public User createUserWithRole(@RequestBody UserRequestDto user)
	{
		return us.createUserWithRole(user);
	}
	
	@PostMapping("/user/role/batch")
	public User createUserWithRoleBatch(@RequestBody UserRoleBatchRequest user)
	{
		return us.createUserRoleBatch(user);
	}
}
