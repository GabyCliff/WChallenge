package com.wchallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="url")
	private String url;
	
	@Column(name="thumbnailurl")
	private String thumbnailUrl;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(nullable=false)
//	private UserAlbum userAlbum;
	
	public Photo () {
		
	}

	public Photo(long id, String title, String url, String thumbnailUrl, UserAlbum userAlbum) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
		//this.userAlbum = userAlbum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

//	public UserAlbum getUserAlbum() {
//		return userAlbum;
//	}

//	public void setUserAlbum(UserAlbum userAlbum) {
//		this.userAlbum = userAlbum;
//	}
	
	

}
