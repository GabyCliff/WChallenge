package com.wchallenge.servicesTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.model.CommentModel;
import com.wchallenge.service.ICommentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTest {
	
	@Autowired
	private ICommentService commentService;
	
	@Test
	public void testGetAllComments() {
		List<CommentModel> comments = commentService.getAll();

		assertThat(comments).isNotEmpty().isNotNull();
	}
	
	@Test
	public void testGetComment() {
		CommentModel comment = commentService.findByName("id labore ex et quam laborum");
		CommentModel expectedComment = new CommentModel(1, 1, "id labore ex et quam laborum", "Eliseo@gardner.biz", "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");
		
		assertThat(comment).isEqualTo(expectedComment);
	}
	
	@Test
	public void getCommentByPost() {
		CommentModel comment = commentService.findByPost(1).get(3);
		CommentModel expectedComment = new CommentModel(1, 4, "alias odio sit", "Lew@alysha.tv", "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati");
		
		assertThat(comment).isEqualTo(expectedComment);
	}
	
	@Test
	public void getCommentByUserId() {
		CommentModel[] comments = commentService.findByUser(2).get(0);
		CommentModel comment = comments[0];
		CommentModel expectedComment = new CommentModel(11, 51, "molestias et odio ut commodi omnis ex", "Laurie@lincoln.us", "perferendis omnis esse\nvoluptate sit mollitia sed perferendis\nnemo nostrum qui\nvel quis nisi doloribus animi odio id quas");
		
		assertThat(comment).isEqualTo(expectedComment);
	}

}
