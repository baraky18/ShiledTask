package com.shield.PhotosTask.service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.shield.PhotosTask.Persistence.DAO.PhotoDataDAO;
import com.shield.PhotosTask.Persistence.mapper.PhotoDataPersistenceMapper;
import com.shield.PhotosTask.application.DTO.PhotoDataApplicationDTO;
import com.shield.PhotosTask.repository.PhotosRepository;

@Service
public class FetchFromPhotosStorageService {

	@Autowired
	private PhotosRepository photosRepository;

	@Autowired
	private PhotoDataPersistenceMapper photoDataPersistenceMapper;
	
	@Value("${downloaded.files.target.folder}")
	private String downloadedFilesTargetFolder;

	public List<PhotoDataApplicationDTO> listAllPhotos() {
		List<PhotoDataDAO> allPhotosDAOList = (List<PhotoDataDAO>) photosRepository.findAll();
		List<PhotoDataApplicationDTO> allPhotosDTOList = photoDataPersistenceMapper.mapDAOToApplicationDTOList(allPhotosDAOList);
		return allPhotosDTOList;
	}

	public List<PhotoDataApplicationDTO> listPhotosPerAlbum(int albumId) {
		List<PhotoDataDAO> photosPerAlbumDAOList = photosRepository.findByAlbumId(albumId);
		List<PhotoDataApplicationDTO> photosPerAlbumDTOList = photoDataPersistenceMapper.mapDAOToApplicationDTOList(photosPerAlbumDAOList);
		return photosPerAlbumDTOList;
	}
	
	public Resource getPhoto(int albumId, int photoId) throws FileNotFoundException, MalformedURLException {
		PhotoDataDAO photoDataDAO = photosRepository.findByAlbumIdAndPhotoId(albumId, photoId);
		if(photoDataDAO != null){
			String fileName = photoDataDAO.getAlbumId() + "_" + 
					photoDataDAO.getPhotoId() + "_" + photoDataDAO.getTitle() + ".jpeg";
			Path root = Paths.get("src", "main", "resources", "downloadedFilesStorage");
			Path file = root.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists()) {
				return resource;
			} else {
				throw new FileNotFoundException("File not found " + fileName);
			}
		}
		else{
			throw new FileNotFoundException("photo id " + photoId + " in album id " + albumId + " was not found");
		}
	}
	
}
