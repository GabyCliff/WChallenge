package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wchallenge.model.AlbumModel;
import com.wchallenge.service.IAlbumService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/albums")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@GetMapping("")
	@ApiOperation(value = "Return all Albums", response = AlbumModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Albums")
	public ResponseEntity<List<AlbumModel>> getAlbums() {
		List<AlbumModel> albums = albumService.getAll();
		return new ResponseEntity<List<AlbumModel>>(albums, HttpStatus.OK);
	}
	
	@GetMapping("user/{id}")
	@ApiOperation(value = "Giving a user id, return the albums of that user", response = AlbumModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Albums")
	public ResponseEntity<List<AlbumModel>> getAlbumByUser(@PathVariable("id") long id) {
		List<AlbumModel> albums = albumService.findByUser(id);
		return new ResponseEntity<List<AlbumModel>>(albums, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Giving an id, return the album", response = AlbumModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Album")
	public ResponseEntity<AlbumModel> getAlbum(@PathVariable("id") long id) {
		AlbumModel album = albumService.getAlbum(id);
		return new ResponseEntity<AlbumModel>(album, HttpStatus.OK);
	}

}
