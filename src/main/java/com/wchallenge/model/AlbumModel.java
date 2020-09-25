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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumModel other = (AlbumModel) obj;
		if (Id != other.Id)
			return false;
		if (Userid != other.Userid)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumModel [Userid=" + Userid + ", Id=" + Id + ", title=" + title + "]";
	}
    
    

}
