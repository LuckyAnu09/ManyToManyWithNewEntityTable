package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.RoleBatch;
import com.example.dto.UserRequestDto;
import com.example.dto.UserRoleBatchRequest;
import com.example.entity.Batch;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import com.example.entity.UserRoleBatch;
import com.example.repository.BatchRepository;
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
	BatchRepository br;

	public List<User> getAllUsers() {

		return ur.findAll();
	}

	public User createUserWithRole(UserRequestDto user) {

		// can be done using mapper
		User newUser = new User(user.getUserName(), user.getUserEmail(), user.getUserNumber());

		for (int roleId : user.getRolesId()) {

			Role role = rr.findById(roleId);

			UserRole userRole = new UserRole(newUser, role);

			newUser.userRoles.add(userRole);

		}

		return ur.save(newUser);
	}

	public User createUserRoleBatch(UserRoleBatchRequest user) {

		User newUser = new User(user.getUserName(), user.getUserEmail(), user.getUserNumber());

		for (RoleBatch rolebatch : user.getRoleBatches()) {
			Role role = rr.findById(rolebatch.getRoleId());
			UserRole userRole = new UserRole(newUser, role);
		//	List<Batch> batch = br.findAllById(rolebatch.getBatchId());
			for(int batchId:rolebatch.getBatchId() )
			{
				Batch batch = br.getById(batchId);
				
				UserRoleBatch urb = new UserRoleBatch(userRole,batch);
				
				userRole.userRoleBatches.add(urb);
				
			}
			
			newUser.userRoles.add(userRole);

		}
		return ur.save(newUser);
	}

}
