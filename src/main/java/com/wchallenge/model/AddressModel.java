package com.wchallenge.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Address of a User from JSONPlaceholder Online REST API")
public class AddressModel {
	
	@ApiModelProperty(notes = "The street of a user's address")
	private String street;
	
	@ApiModelProperty(notes = "The suite of a user's address")
	private String suite;
	
	@ApiModelProperty(notes = "The city of a user's address")
	private String city;
	
	@ApiModelProperty(notes = "The zipcode of a user's address")
	private String zipcode;
	
	@ApiModelProperty(notes = "The geographic location of a user")
	private GeoModel geo;
	
	public AddressModel () {
		
	}

	public AddressModel(String street, String suite, String city, String zipcode, GeoModel geo) {
		super();
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geo = geo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public GeoModel getGeo() {
		return geo;
	}

	public void setGeo(GeoModel geo) {
		this.geo = geo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((geo == null) ? 0 : geo.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((suite == null) ? 0 : suite.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		AddressModel other = (AddressModel) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (geo == null) {
			if (other.geo != null)
				return false;
		} else if (!geo.equals(other.geo))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (suite == null) {
			if (other.suite != null)
				return false;
		} else if (!suite.equals(other.suite))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressModel [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode
				+ ", geo=" + geo + "]";
	}
	
	

}
