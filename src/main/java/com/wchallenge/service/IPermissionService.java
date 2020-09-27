package com.wchallenge.service;

import java.util.List;

import com.wchallenge.entities.Permission;

public interface IPermissionService {
	
	public List<Permission> getAll();
	public Permission findById(long id);
	public Permission insert(Permission permission);
	public Permission update(Permission permission);
	public boolean remove(long id);	

}
