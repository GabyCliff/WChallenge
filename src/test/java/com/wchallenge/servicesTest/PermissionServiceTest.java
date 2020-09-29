package com.wchallenge.servicesTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.entities.Permission;
import com.wchallenge.model.PermissionEnum;
import com.wchallenge.repositories.IPermissionRepository;
import com.wchallenge.service.IPermissionService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionServiceTest {
	
	
	@Autowired
	private IPermissionService permissionService;
	
	@MockBean
	private IPermissionRepository permissionRepository;
	
	@Test
	public void testGetPermissionById() {
		
		Permission expectedPermission = new Permission(1, PermissionEnum.READ, 20);
		expectedPermission.setId(1);
		
		Mockito.when(permissionRepository.findById(expectedPermission.getId())).thenReturn(expectedPermission);
		
		Permission permission = permissionService.findById(1);
		
		assertThat(permission.getId()).isEqualTo(1);
		
	}
	
	@Test
	public void testGetAllPermissions() {
		Permission expectedPermission = new Permission(1, PermissionEnum.READ, 20);
		expectedPermission.setId(1);
		List<Permission> expectedPermissions = Arrays.asList(expectedPermission);
		
		Mockito.when(permissionRepository.findAll()).thenReturn(expectedPermissions);
		
		List<Permission> permissions = permissionService.getAll();
		
		assertThat(permissions.get(0).getPermission()).isEqualTo(PermissionEnum.READ);
		assertThat(permissions.size()).isGreaterThan(0);
		
	}
	
	
	
	
	

}
