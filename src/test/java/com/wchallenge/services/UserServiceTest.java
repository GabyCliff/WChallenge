package com.wchallenge.services;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.model.AddressModel;
import com.wchallenge.model.CompanyModel;
import com.wchallenge.model.GeoModel;
import com.wchallenge.model.UserModel;
import com.wchallenge.service.IUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void getAllUsers() {
		List<UserModel> users = userService.getAll();

		assertThat(users).isNotEmpty().isNotNull();
	}
	
	@Test
	public void getUser() {
		UserModel user = userService.findById(1);
		GeoModel geo = new GeoModel("-37.3159", "81.1496");
		AddressModel address = new AddressModel("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", geo);
		CompanyModel company = new CompanyModel("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets");
		UserModel expectedUser = new UserModel(1, "Leanne Graham", "Bret", "Sincere@april.biz", address, "1-770-736-8031 x56442", "hildegard.org", company);		
		
		assertThat(user).isEqualTo(expectedUser);
	}

}
