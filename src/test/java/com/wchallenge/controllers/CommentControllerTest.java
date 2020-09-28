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

import com.wchallenge.model.CommentModel;
import com.wchallenge.service.ICommentService;


@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ICommentService service;
	
	@Test
	public void givenComments_whenGetComments_thenReturnJsonArray() throws Exception{
		
		CommentModel comment = new CommentModel();
		comment.setName("CommentTest");
		
		List<CommentModel> comments = Arrays.asList(comment);
		
		when(service.getAll()).thenReturn(comments);
		
		mvc.perform(get("/comments")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].name", is(comment.getName())));
			
	}
	
	@Test
	public void givenCommentFilteredByName_whenGetCommentFilteredByName_thenReturnJsonArray() throws Exception{
		
		CommentModel comment = new CommentModel();
		comment.setName("CommentTest");
		
		when(service.findByName("name")).thenReturn(comment);
		
		mvc.perform(get("/comments/filterByName/name")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.name", is(comment.getName())));
			
	}
	
	@Test
	public void givenCommentsByPost_whenGetCommentsByPost_thenReturnJsonArray() throws Exception{
		
		CommentModel comment = new CommentModel();
		comment.setName("CommentTest");
		
		List<CommentModel> comments = Arrays.asList(comment);
		
		when(service.findByPost(1)).thenReturn(comments);
		
		mvc.perform(get("/comments/post/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].name", is(comment.getName())));
			
	}
	
	@Test
	public void givenCommentsFilteredByUser_whenGetCommentsFilteredByUser_thenReturnJsonArray() throws Exception{
		
		CommentModel[] comment = new CommentModel[1];
		comment[0] = new CommentModel();
		comment[0].setName("CommentTest");
		
		List<CommentModel[]> c = new ArrayList<CommentModel[]>();
		c.add(comment);
		
		when(service.findByUser(1)).thenReturn(c);
		
		mvc.perform(get("/comments/filterByUser/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].[0].name", is(comment[0].getName())));
			
	}

}
