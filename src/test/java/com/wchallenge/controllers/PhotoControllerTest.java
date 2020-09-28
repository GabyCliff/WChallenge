package com.wchallenge.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.wchallenge.model.PhotoModel;
import com.wchallenge.service.IPhotoService;


@RunWith(SpringRunner.class)
@WebMvcTest(PhotoController.class)
public class PhotoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IPhotoService service;
	
	@Test
	public void givenPhotos_whenGetPhotos_thenReturnJsonArray() throws Exception{
		
		PhotoModel photo = new PhotoModel();
		photo.setTitle("PhotoTest");
		
		List<PhotoModel> photos = Arrays.asList(photo);
		
		when(service.getAll()).thenReturn(photos);
		
		mvc.perform(get("/photos")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].title", is(photo.getTitle())));
			
	}
	
	@Test
	public void givenPhoto_whenGetPhoto_thenReturnJsonArray() throws Exception{
		
		PhotoModel photo = new PhotoModel();
		photo.setTitle("PhotoTest");
		
		when(service.getPhoto(1)).thenReturn(photo);
		
		mvc.perform(get("/photos/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.title", is(photo.getTitle())));
			
	}
	
	@Test
	public void givenPhotosByAlbum_whenGetPhotosByAlbum_thenReturnJsonArray() throws Exception{
		
		PhotoModel photo = new PhotoModel();
		photo.setTitle("PhotoTest");
		
		List<PhotoModel> photos = Arrays.asList(photo);
		
		when(service.findByAlbum(1)).thenReturn(photos);
		
		mvc.perform(get("/photos/album/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].title", is(photo.getTitle())));
			
	}
	
	@Test
	public void givenPhotosByUser_whenGetPhotosByUser_thenReturnJsonArray() throws Exception{
		
		PhotoModel[] photo = new PhotoModel[1];
		photo[0] = new PhotoModel();
		photo[0].setTitle("PhotoTest");
		
		List<PhotoModel[]> p = new ArrayList<PhotoModel[]>();
		p.add(photo);
		
		when(service.getPhotosByUser(1)).thenReturn(p);
		
		mvc.perform(get("/photos/user/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].[0].title", is(photo[0].getTitle())));
			
	}

}
