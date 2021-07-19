package com.shield.PhotosTask.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shield.PhotosTask.Persistence.DAO.PhotoDataDAO;
import com.shield.PhotosTask.Persistence.mapper.PhotoDataPersistenceMapper;
import com.shield.PhotosTask.gateways.PhotoFilesGateway;
import com.shield.PhotosTask.gateways.PhotosListGateway;
import com.shield.PhotosTask.gateways.DTO.PhotoDataGatewayDTO;
import com.shield.PhotosTask.gateways.mapper.PhotoDataGatewaysMapper;
import com.shield.PhotosTask.repository.PhotosRepository;
import com.shield.PhotosTask.service.model.PhotoDataModel;

@Service
public class InitializePhotosStorageService {

	@Autowired
	private PhotosListGateway photosListGateway;
	
	@Autowired
	private PhotoDataGatewaysMapper photoDataGatewaysMapper;
	
	@Autowired
	private PhotoFilesGateway photoFilesGateway;
	
	@Autowired
	private PhotosRepository photosRepository;
	
	@Autowired
	private PhotoDataPersistenceMapper photoDataPersistenceMapper;
	
	public void initializePhotosStorage() throws IOException{
		if(photosRepository.count() == 0){
			PhotoDataGatewayDTO[] photoDataGatewayDTOArr = photosListGateway.getPhotosList();
			List<PhotoDataModel> photoDataModelList = photoDataGatewaysMapper.mapToModelList(photoDataGatewayDTOArr);
			List<PhotoDataModel> photoDataModelListIncludingDownloadData = photoFilesGateway.downloadPhotoFilesToLocalStorage(photoDataModelList);
			List<PhotoDataDAO> photoDataDAOList = photoDataPersistenceMapper.mapModelToDAO(photoDataModelListIncludingDownloadData);
			photosRepository.saveAll(photoDataDAOList);
		}
	}
}
