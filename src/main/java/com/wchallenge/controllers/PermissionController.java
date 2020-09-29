package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("permissions")
public class PermissionController {
	
	@Autowired
	@Qualifier("permissionService")
	private IPermissionService permissionService;
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/addSharedAlbum")
	@ApiOperation(value = "Sending a Permission, create a user permission for an album", response = Permission.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created Permission"),
			@ApiResponse(code = 409, message = "Conflict to create a Permission")
	})
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
	@ApiOperation(value = "Return all Permissions", response = Permission.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Permissions")
	public ResponseEntity<List<Permission>> getPermissions(){
		List<Permission> permissions = permissionService.getAll();
		return new ResponseEntity<List<Permission>>(permissions, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Giving an id, return the permission", response = Permission.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Permission")
	public ResponseEntity<Permission> getPermission(@PathVariable("id") long id) {
		Permission permission = permissionService.findById(id);
		return new ResponseEntity<Permission>(permission, HttpStatus.OK);
	}
	
	@GetMapping("/getUserPermission/{albumId}/{permissionType}")
	@ApiOperation(value = "Giving a album id and a permission type, return the users with that permissions in that album", response = UserModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Users")
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
	@ApiOperation(value = "Sending a Permission, update a user permission for an album", response = Permission.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully updated Permission"),
			@ApiResponse(code = 409, message = "Conflict to update a Permission")
	})
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
