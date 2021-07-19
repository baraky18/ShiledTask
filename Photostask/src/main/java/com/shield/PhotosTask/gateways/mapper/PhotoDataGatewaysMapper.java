package com.shield.PhotosTask.gateways.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shield.PhotosTask.gateways.DTO.PhotoDataGatewayDTO;
import com.shield.PhotosTask.service.model.PhotoDataModel;

@Component
public class PhotoDataGatewaysMapper {

	public List<PhotoDataModel> mapToModelList(PhotoDataGatewayDTO[] photoDataGatewayDTOArr) {
		List<PhotoDataModel> photoDataModelList = new ArrayList<PhotoDataModel>();
		for(int i=0; i<photoDataGatewayDTOArr.length; i++){
			PhotoDataModel photoDataModel = new PhotoDataModel();
			photoDataModel.setAlbumId(photoDataGatewayDTOArr[i].getAlbumId());
			photoDataModel.setId(photoDataGatewayDTOArr[i].getId());
			photoDataModel.setThumbnailUrl(photoDataGatewayDTOArr[i].getThumbnailUrl());
			photoDataModel.setTitle(photoDataGatewayDTOArr[i].getTitle());
			photoDataModel.setUrl(photoDataGatewayDTOArr[i].getUrl());
			photoDataModelList.add(photoDataModel);
		}
		return photoDataModelList;
	}

}
