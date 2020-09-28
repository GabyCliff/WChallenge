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

import com.wchallenge.entities.Permission;
import com.wchallenge.repositories.IPermissionRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(PermissionController.class)
public class PermissionControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IPermissionRepository repository;
	
	@Test
	public void givenAlbums_whenGetAlbums_thenReturnJsonArray() throws Exception{
		
		Permission permission = new Permission();
		permission.setAlbumId(1);
		
		List<Permission> permissions = Arrays.asList(permission);
		
		when(repository.findAll()).thenReturn(permissions);
		
		mvc.perform(get("/permissions")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
//			      .andExpect(jsonPath("$[0].id", is(permission.getId())));
			
	}

}
