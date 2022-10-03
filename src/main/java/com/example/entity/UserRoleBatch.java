package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_ninja_user_role_batch_map")
public class UserRoleBatch {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="urb_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_role_id")
	private UserRole userRole;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	public UserRoleBatch(UserRole userRole, Batch batch) {
		super();
		this.userRole = userRole;
		this.batch = batch;
	}

}
