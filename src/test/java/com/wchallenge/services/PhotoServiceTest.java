package com.wchallenge.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wchallenge.model.PhotoModel;
import com.wchallenge.service.IPhotoService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PhotoServiceTest {
	
	@Autowired
	private IPhotoService photoService;
	
	@Test
	public void getAllPhotos() {
		List<PhotoModel> photos = photoService.getAll();

		assertThat(photos).isNotEmpty().isNotNull();
	}
	
	@Test
	public void getPhoto() {
		PhotoModel photo = photoService.getPhoto(1);
		PhotoModel expectedPhoto = new PhotoModel(1, 1, "accusamus beatae ad facilis cum similique qui sunt", "https://via.placeholder.com/600/92c952", "https://via.placeholder.com/150/92c952");
		
		assertThat(photo).isEqualTo(expectedPhoto);
	}
	
	@Test
	public void getByAlbum() {
		PhotoModel photo = photoService.findByAlbum(1).get(5);
		PhotoModel expectedPhoto = new PhotoModel(6, 1, "accusamus ea aliquid et amet sequi nemo", "https://via.placeholder.com/600/56a8c2", "https://via.placeholder.com/150/56a8c2");
		
		assertThat(photo).isEqualTo(expectedPhoto);
	}
	
	@Test
	public void getByUser() {
		PhotoModel[] photos = photoService.getPhotosByUser(2).get(0);
		PhotoModel photo = photos[0];
		PhotoModel expectedPhoto = new PhotoModel(501, 11, "asperiores exercitationem voluptates qui amet quae necessitatibus facere", "https://via.placeholder.com/600/cda4c0", "https://via.placeholder.com/150/cda4c0");
		
		assertThat(photo).isEqualTo(expectedPhoto);
	}

}
