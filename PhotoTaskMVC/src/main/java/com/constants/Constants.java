package com.constants;

public class Constants {

	public static final String PHOTO_LIST_URL = "http://localhost:8356/photos/list";
	public static final String PHOTO_LIST_BY_ALBUM_URL = "http://localhost:8356/photos/list-by-album?albumId=";
	public static final String DOWNLOAD_PHOTO_URL = "http://localhost:8356/photos/download?albumId=%1$s&photoId=%2$s";
	public static final String RESOURCE_FILE_LOCATION = "C:\\Users\\baraky\\workspace\\PhotoTaskMVC\\src\\main\\webapp\\downloadedResources\\";
	public static final String ALBUM_ID_OR_PHOTO_ID_NOT_FOUND = "Album id or Photo id was not found. please try again";
	public static final String FILE_CANNOT_BE_DOWNLOADED = "file couldn't be downloaded. please try again";
}
