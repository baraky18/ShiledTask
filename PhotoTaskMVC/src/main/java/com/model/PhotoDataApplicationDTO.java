package com.model;

public class PhotoDataApplicationDTO {

	private int albumId;
	private int id;
	private String title;
	
	public PhotoDataApplicationDTO(){}
	
	public String toString(){
		String string = "album id: " + this.albumId + " "
				+"photo id: " + this.id + " "
				+"title: " + this.title + " ";
		return string;		
	}
	
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
