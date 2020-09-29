package com.wchallenge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Company of a User from JSONPlaceholder Online REST API")
public class CompanyModel {
	
	@ApiModelProperty(notes = "The name of the Companny")
	private String name;
	
	@ApiModelProperty(notes = "The catchphrase of the Company")
	private String catchPhrase;
	private String bs;
	
	public CompanyModel () {
		
	}

	public CompanyModel(String name, String catchPhrase, String bs) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bs == null) ? 0 : bs.hashCode());
		result = prime * result + ((catchPhrase == null) ? 0 : catchPhrase.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CompanyModel other = (CompanyModel) obj;
		if (bs == null) {
			if (other.bs != null)
				return false;
		} else if (!bs.equals(other.bs))
			return false;
		if (catchPhrase == null) {
			if (other.catchPhrase != null)
				return false;
		} else if (!catchPhrase.equals(other.catchPhrase))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
