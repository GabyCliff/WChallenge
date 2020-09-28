package com.wchallenge.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.model.AlbumModel;
import com.wchallenge.service.IAlbumService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlbumServiceTest {
	
	@Autowired
	private IAlbumService albumService;
	
	@Test
	public void getAllAlbums() {
		List<AlbumModel> albums = albumService.getAll();

		assertThat(albums).isNotEmpty().isNotNull();
	}
	
	@Test
	public void getAlbum() {
		AlbumModel album = albumService.getAlbum(1);
		AlbumModel expectedAlbum = new AlbumModel(1, 1, "quidem molestiae enim");
		assertThat(album).isEqualTo(expectedAlbum);
	}
	
	@Test
	public void getAlbumByUser() {
		AlbumModel album = albumService.findByUser(2).get(0);
		AlbumModel expectedAlbum = new AlbumModel(11, 2, "quam nostrum impedit mollitia quod et dolor");
		assertThat(album).isEqualTo(expectedAlbum);
	}

}
