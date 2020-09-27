package com.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wchallenge.model.PermissionEnum;

@Entity
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_id")
	private long userId;

	@Enumerated(EnumType.STRING)
	private PermissionEnum permission;
	
	@Column(name = "album_id")
	private long albumId;
	
}
