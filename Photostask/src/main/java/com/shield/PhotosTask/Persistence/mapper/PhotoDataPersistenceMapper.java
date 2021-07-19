package com.shield.PhotosTask.Persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shield.PhotosTask.Persistence.DAO.PhotoDataDAO;
import com.shield.PhotosTask.application.DTO.PhotoDataApplicationDTO;
import com.shield.PhotosTask.service.model.PhotoDataModel;

@Component
public class PhotoDataPersistenceMapper {

	public List<PhotoDataApplicationDTO> mapDAOToApplicationDTOList(List<PhotoDataDAO> allPhotosDAOList) {
		List<PhotoDataApplicationDTO> photoDataApplicationDTOList = new ArrayList<PhotoDataApplicationDTO>();
		for(int i=0; i<allPhotosDAOList.size(); i++){
			PhotoDataApplicationDTO photoDataApplicationDTO = new PhotoDataApplicationDTO();
			photoDataApplicationDTO.setAlbumId(allPhotosDAOList.get(i).getAlbumId());
			photoDataApplicationDTO.setId(allPhotosDAOList.get(i).getPhotoId());
			photoDataApplicationDTO.setTitle(allPhotosDAOList.get(i).getTitle());
			photoDataApplicationDTOList.add(photoDataApplicationDTO);
		}
		return photoDataApplicationDTOList;
	}

	public List<PhotoDataDAO> mapModelToDAO(List<PhotoDataModel> photoFileIncludingDownloadDataList) {
		List<PhotoDataDAO> photoDataDAOList = new ArrayList<PhotoDataDAO>();
		for(int i=0; i<photoFileIncludingDownloadDataList.size(); i++){
			PhotoDataDAO photoDataDAO = new PhotoDataDAO();
			photoDataDAO.setAlbumId(photoFileIncludingDownloadDataList.get(i).getAlbumId());
			photoDataDAO.setDownloadDatetime(photoFileIncludingDownloadDataList.get(i).getDownloadDatetime());
			photoDataDAO.setFileSize(photoFileIncludingDownloadDataList.get(i).getFileSize());
			photoDataDAO.setLocalPath(photoFileIncludingDownloadDataList.get(i).getLocalPath());
			photoDataDAO.setPhotoId(photoFileIncludingDownloadDataList.get(i).getId());
			photoDataDAO.setTitle(photoFileIncludingDownloadDataList.get(i).getTitle());
			photoDataDAOList.add(photoDataDAO);
		}
		return photoDataDAOList;
	}

}
