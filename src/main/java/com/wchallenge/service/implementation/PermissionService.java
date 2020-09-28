package com.wchallenge.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wchallenge.entities.Permission;
import com.wchallenge.repositories.IPermissionRepository;
import com.wchallenge.service.IPermissionService;

@Service
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

	@Override
	public boolean exist(long id) {
		if(permissionRepository.existsById(id)) {
			return true;
		}
		else return false;
	}

	@Override
	public boolean isValidToCreate(Permission permission) {
		boolean result = true;
		if(!this.exist(permission.getId())) {
			for(Permission p : this.getAll()) {
				if( p.getAlbumId()==permission.getAlbumId() && p.getUserId()==permission.getUserId()) {
					result = false;
				}
			}
		}
		else if(this.exist(permission.getId())) {
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean isValidToUptade(Permission permission) {
		boolean result = false;
		if(this.exist(permission.getId())) {
			for(Permission p : this.getAll()) {
				if( p.getAlbumId()==permission.getAlbumId() && p.getUserId()==permission.getUserId() && p.getId()==permission.getId()) {
					result = true;
				}
			}
		}
		
		return result;
	}

	

}
