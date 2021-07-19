package com.shield.PhotosTask.Persistence.DAO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_photo_data")
public class PhotoDataDAO {

	@Column(name="table_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="photo_id")
	private int photoId;
	
	@Column(name="download_datetime")
	private Date downloadDatetime;
	
	@Column(name="local_path")
	private String localPath;
	
	@Column(name="file_size")
	private long fileSize;
	
	@Column(name="album_id")
	private int albumId;
	
	@Column(name="title")
	private String title;

	public int getId() {
		return id;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public Date getDownloadDatetime() {
		return downloadDatetime;
	}

	public void setDownloadDatetime(Date downloadDatetime) {
		this.downloadDatetime = downloadDatetime;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
