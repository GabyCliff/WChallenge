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

import com.wchallenge.controllers.UserController;
import com.wchallenge.model.UserModel;
import com.wchallenge.service.IUserService;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IUserService service;
	
	@Test
	public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception{
		
		UserModel user = new UserModel();
		user.setName("UserTest");
		
		List<UserModel> users = Arrays.asList(user);
		
		when(service.getAll()).thenReturn(users);
		
		mvc.perform(get("/users")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$[0].name", is(user.getName())));
			
	}
	
	@Test
	public void givenUser_whenGetUser_thenReturnJsonArray() throws Exception{
		
		UserModel user = new UserModel();
	
		user.setName("UserTest");
		
		when(service.findById(1)).thenReturn(user);
		
		mvc.perform(get("/users/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.name", is(user.getName())));
			
	}

}
