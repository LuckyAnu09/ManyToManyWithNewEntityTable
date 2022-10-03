package com.example.dto;

import java.util.Set;

import com.example.entity.Batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleBatch {
	
	private int RoleId;
	
	private Set<Integer> BatchId;

}
