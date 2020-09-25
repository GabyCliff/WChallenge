package com.wchallenge.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.helpers.ApiHelper;
import com.wchallenge.model.PhotoModel;
import com.wchallenge.service.IPhotoService;

@Service
public class PhotoService implements IPhotoService{
	
	private final RestTemplate restTemplate;

    private PhotoService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

	@Override
	public List<PhotoModel> getAll() {
		// TODO Auto-generated method stub
		return Arrays.asList(restTemplate.getForObject(ApiHelper.PHOTOS, PhotoModel[].class));
	}
	
	@Override
	public List<PhotoModel> findByAlbum(long id) {
		List<PhotoModel> photos = this.getAll();
        List<PhotoModel> result = photos.stream().filter(f -> f.getAlbumId()==id).collect(Collectors.toList());
        return result;
	}

}
