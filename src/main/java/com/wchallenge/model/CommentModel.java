package com.wchallenge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Comments from JSONPlaceholder Online REST API")
public class CommentModel {
	
	@ApiModelProperty(notes = "The id of the post that contains it")
	private long postId;
	private long id;
	
	@ApiModelProperty(notes = "The name of the comment")
	private String name;
	
	@ApiModelProperty(notes = "The email of the comment")
	private String email;
	
	@ApiModelProperty(notes = "The body of the comment")
	private String body;
	
	public CommentModel () {
		
	}

	public CommentModel(long postId, long id, String name, String email, String body) {
		super();
		this.postId = postId;
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (postId ^ (postId >>> 32));
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
		CommentModel other = (CommentModel) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentModel [postId=" + postId + ", id=" + id + ", name=" + name + ", email=" + email + ", body="
				+ body + "]";
	}
	
	

}
