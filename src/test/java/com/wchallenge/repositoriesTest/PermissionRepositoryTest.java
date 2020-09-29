package com.wchallenge.repositoriesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.entities.Permission;
import com.wchallenge.model.PermissionEnum;
import com.wchallenge.repositories.IPermissionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PermissionRepositoryTest {
	
	@Autowired
	private IPermissionRepository repository;
	
	@Test
	@Rollback(false)
	public void testCreatePermission() {
		Permission oneTestPermission = new Permission(8, PermissionEnum.WRITE, 6);
		Permission persistedPermission = repository.save(oneTestPermission);
		
		assertNotNull(persistedPermission);

	}
	
	@Test
	public void testFindPermissionByIdExist() {
		
		Permission oneTestPermission = repository.findById(1);
		
		assertThat(oneTestPermission.getId()).isEqualTo(1);
		
	}
	
	@Test
	public void testFindPermissionByIdNotExist() {
		
		Permission oneTestPermission = repository.findById(9999);
		
		assertNull(oneTestPermission);
		
	}
	
	@Test
	@Rollback(false)
	public void testUpdatePermission() {
		
		Permission oneTestPermission = new Permission(8, PermissionEnum.READ, 6);
		oneTestPermission.setId(1);
		repository.save(oneTestPermission);
		
		Permission updatedPermission = repository.findById(1);
		
		assertThat(updatedPermission.getPermission()).isEqualTo(PermissionEnum.READ);
		
	}
	
	@Test
	public void testGetAllPermissions() {
		List<Permission> permissions = repository.findAll();
		
		assertThat(permissions).size().isGreaterThan(0);
	}

}
