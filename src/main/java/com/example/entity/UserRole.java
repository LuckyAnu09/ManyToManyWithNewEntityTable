package com.example.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_ninja_user_role_map")
public class UserRole {
	
	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="user_role_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@MapsId("userId")
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	//@MapsId("roleId")
	@JoinColumn(name="role_id")
	private Role role;

}
