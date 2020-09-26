package com.wchallenge.entities;

public enum Permission {

	READ(1), WRITE(2), READ_WRITE(3);

	private long id;
	
	Permission(long id) {
		
		this.id = id;
	}
	
	public static Permission getId(long id) {
		for (Permission p : values()) {
			if (p.id == id) {
				return p;
			}
		}
		return null;
		
		
	}
	
	
	

}
