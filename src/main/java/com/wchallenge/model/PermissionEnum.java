package com.wchallenge.model;

public enum PermissionEnum {

	READ(1), WRITE(2), READ_WRITE(3);

	private long id;
	
	PermissionEnum(long id) {
		
		this.id = id;
	}
	
	public static PermissionEnum getById(long id) {
		for (PermissionEnum p : values()) {
			if (p.id == id) {
				return p;
			}
		}
		return null;
		
		
	}
	
	
	

}
