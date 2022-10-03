package com.example.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	//@ToString
	public class UserRoleBatchRequest {
		
		
		
		private String userName;
		
		private String userEmail;
		
		private int userNumber;
		
		private Set<RoleBatch> roleBatches;


	}

