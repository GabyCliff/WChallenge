package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Permission> addSharedAlbum(@RequestBody Permission permission) {
		Permission p = new Permission();
		if(permissionService.isValidToCreate(permission)) {
			p = permissionService.insert(permission);
			return new ResponseEntity<Permission>(p, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Permission>(p, HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Permission>> getPermissions(){
		List<Permission> permissions = permissionService.getAll();
		return new ResponseEntity<List<Permission>>(permissions, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Permission> getPermission(@PathVariable("id") long id) {
		Permission permission = permissionService.findById(id);
		return new ResponseEntity<Permission>(permission, HttpStatus.OK);
	}
	
	@GetMapping("/getUserPermission/{albumId}/{permissionType}")
	public ResponseEntity<List<UserModel>> getUserPermission(@PathVariable("albumId") long albumId, @PathVariable("permissionType") int permissionType){
		List<UserModel> users = new ArrayList<UserModel>();
		List<Permission> perm = permissionService.getAll();
		for(Permission p : perm) {
			if( p.getAlbumId()==albumId && p.getPermission()==PermissionEnum.getById(permissionType)) {
				users.add(userService.findById(p.getUserId()));
			}
		}
		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}
	
	@PostMapping("/manage")
	public ResponseEntity<Permission> managePermission(@RequestBody Permission newPermission) {
		Permission p = new Permission();
		if(permissionService.isValidToUptade(newPermission)) {
			p = permissionService.update(newPermission);
			return new ResponseEntity<Permission>(p, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Permission>(p, HttpStatus.CONFLICT);
		}
	}
	
	

}
