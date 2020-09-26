package com.wchallenge.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wchallenge.helpers.ApiHelper;
import com.wchallenge.model.CommentModel;
import com.wchallenge.service.ICommentService;

@Service
public class CommentService implements ICommentService{
	private final RestTemplate restTemplate;

    private CommentService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

	@Override
	public List<CommentModel> getAll() {
		return Arrays.asList(restTemplate.getForObject(ApiHelper.COMMENTS, CommentModel[].class));
	}

	@Override
	public List<CommentModel> findByPost(long id) {
		List<CommentModel> comments = this.getAll();
        List<CommentModel> result = comments.stream().filter(f -> f.getPostId()==id).collect(Collectors.toList());
        return result;
	}

}
