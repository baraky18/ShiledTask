package com.shield.PhotosTask.application.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shield.PhotosTask.application.DTO.PhotoDataApplicationDTO;
import com.shield.PhotosTask.service.FetchFromPhotosStorageService;
import com.shield.PhotosTask.service.InitializePhotosStorageService;

@RestController
@RequestMapping("/photos")
public class PhotosController {

	@Autowired
	private FetchFromPhotosStorageService fetchFromPhotosStorageService;
	
	@Autowired
	private InitializePhotosStorageService initializePhotosStorageService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<PhotoDataApplicationDTO> listAllPhotos() throws IOException{
		initializePhotosStorageService.initializePhotosStorage();
		return fetchFromPhotosStorageService.listAllPhotos();
	}
	
	@RequestMapping("/list-by-album")
	@ResponseBody
	public List<PhotoDataApplicationDTO> listPhotosPerAlbum(@RequestParam int albumId) throws IOException{
		initializePhotosStorageService.initializePhotosStorage();
		return fetchFromPhotosStorageService.listPhotosPerAlbum(albumId);
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public HttpEntity<Resource> download(@RequestParam int albumId, @RequestParam int photoId) {
		try{
			initializePhotosStorageService.initializePhotosStorage();
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);
			return new HttpEntity<Resource>(fetchFromPhotosStorageService.getPhoto(albumId, photoId), headers);
		}
		catch(IOException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", e);
		}

	}
}
