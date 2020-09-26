package com.wchallenge.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.helpers.ApiHelper;
import com.wchallenge.model.AlbumModel;
import com.wchallenge.service.IAlbumService;

@Service
public class AlbumService implements IAlbumService{
	
	private final RestTemplate restTemplate;

    private AlbumService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

	@Override
	public List<AlbumModel> getAll() {
		return Arrays.asList(restTemplate.getForObject(ApiHelper.ALBUMS, AlbumModel[].class));
	}

	@Override
	public List<AlbumModel> findByUser(long id) {
		List<AlbumModel> albums = this.getAll();
        List<AlbumModel> result = albums.stream().filter(f -> f.getUserid()==id).collect(Collectors.toList());
        return result;
	}

}
