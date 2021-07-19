package com.shield.PhotosTask.gateways;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shield.PhotosTask.gateways.DTO.PhotoDataGatewayDTO;

@Component
public class PhotosListGateway {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${photo.list.url}")
	private String photoListUrl;
	
	public PhotoDataGatewayDTO[] getPhotosList() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters); 
		PhotoDataGatewayDTO[] photoDataListGatewayDTO = restTemplate.getForObject(photoListUrl, PhotoDataGatewayDTO[].class);
		return photoDataListGatewayDTO;
	}

}
