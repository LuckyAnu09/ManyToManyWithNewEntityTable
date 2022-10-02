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
import javax.persistence.JoinTable;
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
@Table(name="tbl_ninja_user")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_number")
	private int userNumber;
	
//	@ManyToMany
//	@JoinTable(name="tbl_ninja_user_role_map",
//	joinColumns = @JoinColumn(name="user_id"),
//	inverseJoinColumns = @JoinColumn(name="role_id"))
//	private List<Role> roles;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<UserRole>  userRoles = new HashSet<>();

public User(String userName, String userEmail, int userNumber) {
	super();
	this.userName = userName;
	this.userEmail = userEmail;
	this.userNumber = userNumber;
	
}
	
//	public void addUserRole(UserRole userRole)
//	
//	{	
//		this.addUserRole(userRole);
//	}

}
