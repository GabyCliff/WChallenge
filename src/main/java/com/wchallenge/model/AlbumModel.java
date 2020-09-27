package com.wchallenge.model;

public class AlbumModel {
	
	private long id;
	private long userId;
	private String title;
	
	public AlbumModel() {
		
	}

	public AlbumModel(long id, long userId, String title) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
