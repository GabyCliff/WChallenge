package com.wchallenge.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.helpers.ApiHelper;
import com.wchallenge.model.PostModel;
import com.wchallenge.service.IPostService;

@Service
public class PostService implements IPostService{
	private final RestTemplate restTemplate;

    private PostService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

	@Override
	public List<PostModel> getAll() {
		return Arrays.asList(restTemplate.getForObject(ApiHelper.POSTS, PostModel[].class));
	}

	@Override
	public List<PostModel> findByUser(long id) {
		List<PostModel> posts = this.getAll();
        List<PostModel> result = posts.stream().filter(f -> f.getUserId()==id).collect(Collectors.toList());
        return result;
	}

}
