package com.wchallenge.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wchallenge.entities.Permission;
import com.wchallenge.repositories.IPermissionRepository;
import com.wchallenge.service.IPermissionService;

public class PermissionService implements IPermissionService{
	
	@Autowired
	private IPermissionRepository permissionRepository;

	@Override
	public List<Permission> getAll() {
		// TODO Auto-generated method stub
		return permissionRepository.findAll();
	}

	@Override
	public Permission findById(long id) {
		// TODO Auto-generated method stub
		return permissionRepository.findById(id);
	}

	@Override
	public Permission insert(Permission permission) {
		Permission p = permissionRepository.save(permission);
		return p;
	}

	@Override
	public Permission update(Permission permission) {
		Permission p = permissionRepository.save(permission);
		return p;
	}

	@Override
	public boolean remove(long id) {
		try {
			permissionRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
