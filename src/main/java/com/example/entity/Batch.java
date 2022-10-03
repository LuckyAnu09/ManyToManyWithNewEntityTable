package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_ninja_batch")
public class Batch {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="batch_id")
	private int batchId;
	
	@Column(name="batch_name")
	private String batchName;
	
	@Column(name="batch_des")
	private String batchDes;
	
	@Column(name="batch_status")
	private String batchStatus;
	
	@OneToMany(mappedBy="batch", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<UserRoleBatch> userRoles = new HashSet<>();

}
