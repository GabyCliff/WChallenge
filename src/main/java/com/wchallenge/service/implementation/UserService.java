package com.wchallenge.service.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.model.AlbumModel;
import com.wchallenge.model.PhotoModel;
import com.wchallenge.model.UserModel;
import com.wchallenge.service.IAlbumService;
import com.wchallenge.service.IPhotoService;
import com.wchallenge.service.IUserService;
import com.wchallenge.helpers.ApiHelper;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IAlbumService albumService;
	
	@Autowired
	private IPhotoService photoService;
	
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
