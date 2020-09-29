package com.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.wchallenge.model.PermissionEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "User permissions for shared albums")
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@ApiModelProperty(notes = "The id user of the permission")
	private long userId;

	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "The permission type")
	private PermissionEnum permission;
	
	@Column
	@ApiModelProperty(notes = "The id of the shared album")
	private long albumId;
	
	public Permission() {
		
	}

	public Permission(long userId, PermissionEnum permission, long albumId) {
		super();
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
