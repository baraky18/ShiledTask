package com.shield.PhotosTask.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com"})
public class PhotoTaskConfiguration implements WebMvcConfigurer{

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
