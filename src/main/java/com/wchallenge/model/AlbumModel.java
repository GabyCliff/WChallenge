package com.wchallenge.model;

public class AlbumModel {
	
	private long Userid;
    private long Id;
    private String title;
    
    public AlbumModel () {
    	
    }

	public AlbumModel(long userid, long id, String title) {
		super();
		Userid = userid;
		Id = id;
		this.title = title;
	}

	public long getUserid() {
		return Userid;
	}

	public void setUserid(long userid) {
		Userid = userid;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + (int) (Userid ^ (Userid >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AlbumModel [Userid=" + Userid + ", Id=" + Id + ", title=" + title + "]";
	}
    
    

}
