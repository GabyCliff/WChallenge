package com.wchallenge.controllersTest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.wchallenge.controllers.AlbumController;
import com.wchallenge.model.AlbumModel;
import com.wchallenge.service.IAlbumService;


@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IAlbumService service;
	
	@Test
	public void givenAlbums_whenGetAlbums_thenReturnJsonArray() throws Exception{
		
		AlbumModel album = new AlbumModel(1, 1, "AlbumTest");
		
		List<AlbumModel> albums = Arrays.asList(album);
		
		when(service.getAll()).thenReturn(albums);
		
		mvc.perform(get("/albums")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].title", is(album.getTitle())));
			
	}
	
	@Test
	public void givenAlbumsByUser_whenGetAlbumsByUser_thenReturnJsonArray() throws Exception{
		
		AlbumModel album = new AlbumModel(1, 1, "AlbumTest");
		
		List<AlbumModel> albums = Arrays.asList(album);
		
		when(service.findByUser(1)).thenReturn(albums);
		
		mvc.perform(get("/albums/user/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].title", is(album.getTitle())));
			
	}

	@Test
	public void givenAlbum_whenGetAlbum_thenReturnJsonArray() throws Exception{
		
		AlbumModel album = new AlbumModel(1, 1, "AlbumTest");
		
		when(service.getAlbum(1)).thenReturn(album);
		
		mvc.perform(get("/albums/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.title", is(album.getTitle())));
			
	}

}
