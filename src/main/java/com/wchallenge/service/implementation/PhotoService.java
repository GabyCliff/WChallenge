package com.wchallenge.service.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.helpers.ApiHelper;
import com.wchallenge.model.AlbumModel;
import com.wchallenge.model.PhotoModel;
import com.wchallenge.service.IAlbumService;
import com.wchallenge.service.IPhotoService;

@Service
public class PhotoService implements IPhotoService{
	
	@Autowired
	private IAlbumService albumService;
	
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

	@Override
	public PhotoModel getPhoto(long photoId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(ApiHelper.PHOTOS + photoId, PhotoModel.class);
	}

	@Override
	public List<PhotoModel[]> getPhotosByUser(long userId) {
		AlbumModel[] a = {};
		List<PhotoModel[]> p = new ArrayList<PhotoModel[]>();
		ResponseEntity<AlbumModel[]> responseAlbums = restTemplate.getForEntity(ApiHelper.ALBUMS+"?userId="+userId, AlbumModel[].class);
		a = responseAlbums.getBody();
		for (AlbumModel album : a){
			ResponseEntity<PhotoModel[]> responsePhoto = restTemplate.getForEntity(ApiHelper.PHOTOS+"?albumId="+album.getId(),PhotoModel[].class);
			p.add(responsePhoto.getBody());
		}
		return p;
	}

	

}
