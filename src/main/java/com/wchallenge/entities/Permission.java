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
	
	@Column
	private long userId;

	@Enumerated(EnumType.STRING)
	private PermissionEnum permission;
	
	@Column
	private long albumId;
	
	public Permission() {
		
	}

	public Permission(long id, long userId, PermissionEnum permission, long albumId) {
		super();
		this.id = id;
		this.userId = userId;
		this.permission = permission;
		this.albumId = albumId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
	
	public PermissionEnum getPermission() {
		return permission;
	}
	
	public void serPermissions(PermissionEnum permission) {
		this.permission = permission;
	}
	
}
