package com.shield.PhotosTask.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shield.PhotosTask.Persistence.DAO.PhotoDataDAO;



@Repository
public interface PhotosRepository extends CrudRepository<PhotoDataDAO, Serializable>{

	public List<PhotoDataDAO> findByAlbumId(int albumId);
	
	public PhotoDataDAO findByAlbumIdAndPhotoId(int albumId, int photoId);
}
