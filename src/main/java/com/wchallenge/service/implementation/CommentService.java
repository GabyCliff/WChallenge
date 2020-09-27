package com.wchallenge.service.implementation;

import java.util.ArrayList;
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

//	@Override
//	public List<CommentModel[]> getByName(String name) {
//		List<CommentModel[]> c = new ArrayList<CommentModel[]>();
//		PostModel[] p;
//		UserModel user = restTemplate.getForObject(ApiHelper.USERS+"?name="+name.toString(), UserModel.class);
//		ResponseEntity<PostModel[]> responsePosts = restTemplate.getForEntity(ApiHelper.POSTS + "?userId=" + user.getId(), PostModel[].class);
//		p = responsePosts.getBody();
//		for (PostModel post : p) {
//			ResponseEntity<CommentModel[]> responseComments = restTemplate.getForEntity(ApiHelper.COMMENTS + "?postId=" + post.getId(), CommentModel[].class);
//			c.add(responseComments.getBody());
//		}
//		return c;
//	}
	
	

	@Override
	public List<CommentModel[]> findByUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentModel findByName(String name) {
		
		for(CommentModel comment : this.getAll()) {
			if(comment.getName().equals(name)) {
				CommentModel c = comment;
				return c;
			}
		}
		
		return null;
	}

}
