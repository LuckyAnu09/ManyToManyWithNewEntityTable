package com.example.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name="tbl_ninja_role")
public class Role {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int id;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_desc")
	private String roleDescription;
	
//	@ManyToMany(mappedBy="roles")
//	//@JsonIgnore
//	private List<User> Users;
	
	@OneToMany(mappedBy="role", cascade = CascadeType.ALL)
	@JsonIgnore
	Set<UserRole> userRoles = new HashSet<>();;

}
