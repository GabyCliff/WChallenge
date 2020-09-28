package com.wchallenge.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.model.PostModel;
import com.wchallenge.service.IPostService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostServiceTest {
	
	@Autowired
	private IPostService postService;
	
	@Test
	public void getAllPosts() {
		List<PostModel> posts = postService.getAll();

		assertThat(posts).isNotEmpty().isNotNull();
	}
	
	@Test
	public void getPost() {
		PostModel post = postService.findByUser(1).get(0);
		PostModel expectedPost = new PostModel(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
		assertThat(post).isEqualTo(expectedPost);
	}

}
