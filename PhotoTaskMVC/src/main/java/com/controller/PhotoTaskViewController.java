package com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.model.PhotoDataApplicationDTO;
import static com.constants.Constants.*;


@Controller
public class PhotoTaskViewController {

	@Autowired
	private RestTemplate restTemplate;

	private HttpSession session;

	@RequestMapping("/photo-list")
	public ModelAndView photoList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("photo_list");
		PhotoDataApplicationDTO[] list = restTemplate.getForObject(PHOTO_LIST_URL, PhotoDataApplicationDTO[].class);
		session = request.getSession();
		session.setAttribute("photoList", list);
		return mv;
	}

	@RequestMapping("/photo-list-by-album")
	public ModelAndView photoListByAlbum(@RequestParam("albumId") int albumId){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("photo_list_by_album");
		PhotoDataApplicationDTO[] list = restTemplate.getForObject(PHOTO_LIST_BY_ALBUM_URL + albumId, PhotoDataApplicationDTO[].class);
		session.setAttribute("photoList", list);
		return mv;
	}

	@RequestMapping("/download-photo")
	public ModelAndView downloadPhoto(HttpServletRequest request, @RequestParam("albumId") int albumId, @RequestParam("photoId") int photoId){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("download_photo");
		try{
			ResponseEntity<byte[]> response = restTemplate.getForEntity(String.format(DOWNLOAD_PHOTO_URL, albumId, photoId), byte[].class);
			File output = saveOutputFile(albumId, photoId, response);
			request.setAttribute("photo", output);
		}
		catch(HttpClientErrorException e){
			if(HttpStatus.NOT_FOUND == e.getStatusCode()){
				request.setAttribute("error", ALBUM_ID_OR_PHOTO_ID_NOT_FOUND);
			}
		}
		catch(IOException e){
			request.setAttribute("error", FILE_CANNOT_BE_DOWNLOADED);
		}
		return mv;
	}

	private File saveOutputFile(int albumId, int photoId, ResponseEntity<byte[]> response) throws IOException {
		File output = new File(RESOURCE_FILE_LOCATION + albumId + "_" + photoId);
		if(response.getStatusCode().equals(HttpStatus.OK)){  
			ByteArrayInputStream bais = new ByteArrayInputStream(response.getBody());
			BufferedImage bufferedFile = ImageIO.read(bais);
			ImageIO.write(bufferedFile, "jpeg", output);
		}
		return output;
	}
}
