package com.wchallenge.service.implementation;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.model.UserModel;
import com.wchallenge.service.IUserService;
import com.wchallenge.helpers.ApiHelper;

@Service
public class UserService implements IUserService{
	
	private final RestTemplate restTemplate;

    private UserService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

	@Override
	public List<UserModel> getAll() {
		return Arrays.asList(restTemplate.getForObject(ApiHelper.USERS, UserModel[].class));
	}

	@Override
	public UserModel findById(long id) {
		return restTemplate.getForObject(ApiHelper.USERS + id, UserModel.class);
	}



	

}
