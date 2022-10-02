package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserRequestDto;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.repository.UserRoleRepository;

@Service
public class UserService {
	@Autowired
	UserRepository ur;

	@Autowired
	RoleRepository rr;

	@Autowired
	UserRoleRepository urr;

	public List<User> getAllUsers() {

		return ur.findAll();
	}

	public User createUserWithRole(UserRequestDto user) {

		User newUser = new User(user.getUserName(), user.getUserEmail(), user.getUserNumber());

		for (int roleId : user.getRolesId()) {

			Role role = rr.findById(roleId);

			UserRole userRole = new UserRole(newUser, role);

			newUser.userRoles.add(userRole);

		}

		return ur.save(newUser);
	}

}
