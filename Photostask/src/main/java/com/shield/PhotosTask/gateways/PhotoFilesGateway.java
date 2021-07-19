package com.shield.PhotosTask.gateways;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.shield.PhotosTask.service.model.PhotoDataModel;

@Component
public class PhotoFilesGateway {

	@Value("${downloaded.files.target.folder}")
	private String downloadedFilesTargetFolder;

	public List<PhotoDataModel> downloadPhotoFilesToLocalStorage(List<PhotoDataModel> photoDataModelList) throws IOException {
		for(int i=0; i<photoDataModelList.size(); i++){
			try {
				File photoFile = downloadFileFromUrl(photoDataModelList, i);
				populateModelFields(photoDataModelList, i, photoFile);
			}
			catch(Exception e){
				throw e;
			}
		}
		return photoDataModelList;
	}

	private void populateModelFields(List<PhotoDataModel> photoDataModelList, int i, File photoFile) {
		photoDataModelList.get(i).setFileSize(photoFile.length());
		photoDataModelList.get(i).setDownloadDatetime(new Date());
		photoDataModelList.get(i).setLocalPath(photoFile.getAbsolutePath());
	}

	private File downloadFileFromUrl(List<PhotoDataModel> photoDataModelList, int i) throws MalformedURLException, IOException {
		BufferedImage bufferedFile = null;
		URL url = new URL(photoDataModelList.get(i).getUrl());
		bufferedFile = ImageIO.read(url);
		File photoFile = new File(
				downloadedFilesTargetFolder + photoDataModelList.get(i).getAlbumId() + "_" + 
						photoDataModelList.get(i).getId() + "_" + 
						photoDataModelList.get(i).getTitle() + ".jpeg");
		ImageIO.write(bufferedFile, "jpeg", photoFile);
		return photoFile;
	}
}
