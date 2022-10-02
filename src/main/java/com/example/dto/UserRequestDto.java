package com.example.dto;

import java.util.List;
import java.util.Set;

import com.example.entity.Role;
import com.example.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class UserRequestDto {
	
	//private String Id;
	
	private String userName;
	
	private String userEmail;
	
	private int userNumber;
	
	private Set<Integer> rolesId;


}
