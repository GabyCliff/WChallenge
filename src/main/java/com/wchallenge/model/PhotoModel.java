package com.wchallenge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Photos from JSONPlaceholder Online REST API")
public class PhotoModel {
	
	private long id;
	
	@ApiModelProperty(notes = "The id of the album that contains it")
    private long albumId;
	
	@ApiModelProperty(notes = "The title of the photo")
    private String title;
	
	@ApiModelProperty(notes = "The url of the photo")
    private String url;
	
	@ApiModelProperty(notes = "The thumbnail url of the photo")
    private String thumbnailUrl;
    
    public PhotoModel () {
    	
    }

	public PhotoModel(long id, long albumId, String title, String url, String thumbnailUrl) {
		super();
		this.id = id;
		this.albumId = albumId;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (albumId ^ (albumId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((thumbnailUrl == null) ? 0 : thumbnailUrl.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhotoModel other = (PhotoModel) obj;
		if (albumId != other.albumId)
			return false;
		if (id != other.id)
			return false;
		if (thumbnailUrl == null) {
			if (other.thumbnailUrl != null)
				return false;
		} else if (!thumbnailUrl.equals(other.thumbnailUrl))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhotoModel [id=" + id + ", albumId=" + albumId + ", title=" + title + ", url=" + url + ", thumbnailUrl="
				+ thumbnailUrl + "]";
	}
    
    

}
