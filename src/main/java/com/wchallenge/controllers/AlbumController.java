package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wchallenge.model.AlbumModel;
import com.wchallenge.service.IAlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumController {
	
	@Autowired
	private IAlbumService albumService;
	
	@GetMapping("")
	public List<AlbumModel> getAlbums() {
		
		return albumService.getAll();
	}
	
	@GetMapping("user/{id}")
	public List<AlbumModel> getAlbumByUser(@PathVariable("id") long id) {
		List<AlbumModel> albums = new ArrayList<AlbumModel>();
		albums = albumService.findByUser(id);
		return albums;
	}
	
	@GetMapping("/{id}")
	public AlbumModel getAlbum(@PathVariable("id") long id) {
		return albumService.getAlbum(id);
	}

}
