package com.wchallenge.controllers;

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

import com.wchallenge.model.PostModel;
import com.wchallenge.service.IPostService;


@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IPostService service;
	
	@Test
	public void givenPosts_whenGetPosts_thenReturnJsonArray() throws Exception{
		
		PostModel post = new PostModel(1, 1, "PhotoTest", "");
		
		List<PostModel> posts = Arrays.asList(post);
		
		when(service.getAll()).thenReturn(posts);
		
		mvc.perform(get("/posts")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].title", is(post.getTitle())));
			
	}
	
	@Test
	public void givenPostsByUser_whenGetPostsByUser_thenReturnJsonArray() throws Exception{
		
		PostModel post = new PostModel(1, 1, "PhotoTest", "");
		
		List<PostModel> posts = Arrays.asList(post);
		
		when(service.findByUser(1)).thenReturn(posts);
		
		mvc.perform(get("/posts/user/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].title", is(post.getTitle())));
			
	}

}
