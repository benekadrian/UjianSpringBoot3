package com.springboot.utility;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		exposeDirectory("user-images", registry);
		exposeDirectory("comfort-images", registry);
	}
	
	public void exposeDirectory (String dirName,ResourceHandlerRegistry registry ) {
		Path directory = Paths.get(dirName);
		String Path = directory.toFile().getAbsolutePath();
		
		if (dirName.startsWith("../")) {
			dirName=dirName.replace("../", "");
		}
		
		registry.addResourceHandler("/"+dirName+"/**").addResourceLocations("file:/"+Path+"/");
	}

	
	
}
