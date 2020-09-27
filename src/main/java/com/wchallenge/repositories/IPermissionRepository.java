package com.wchallenge.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wchallenge.entities.Permission;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Serializable>{
	
	public abstract Permission findById(long permissionId);

}
