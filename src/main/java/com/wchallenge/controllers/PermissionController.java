package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wchallenge.entities.Permission;
import com.wchallenge.service.IPermissionService;

@RestController
@RequestMapping("permissions")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	@PostMapping("/addSharedAlbum")
	public Permission addSharedAlbum(@RequestBody Permission permission) {
		
		Permission p = permissionService.insert(permission);
		return p;
		
	}
	
	@GetMapping("")
	public List<Permission> getPermissions(){
		return permissionService.getAll();
	}
	
	@GetMapping("/{id}")
	public Permission getPermission(@PathVariable("id") long id) {
		return permissionService.findById(id);
	}
	

}
