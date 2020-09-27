package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wchallenge.entities.Permission;
import com.wchallenge.model.PermissionEnum;
import com.wchallenge.model.UserModel;
import com.wchallenge.service.IPermissionService;
import com.wchallenge.service.IUserService;

@RestController
@RequestMapping("permissions")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	@Autowired
	private IUserService userService;
	
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
	
	@GetMapping("/getUserPermission/{albumId}/{permissionType}")
	public List<UserModel> getUserPermission(@PathVariable("albumId") long albumId, @PathVariable("permissionType") int permissionType){
		List<UserModel> users = new ArrayList<UserModel>();
		List<Permission> perm = permissionService.getAll();
		for(Permission p : perm) {
			if( p.getAlbumId()==albumId && p.getPermission()==PermissionEnum.getById(permissionType)) {
				users.add(userService.findById(p.getUserId()));
			}
		}
		return users;
	}
	
	
	

}
