package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
//@EnableEurekaClient
@ComponentScan("com.example.controller")
public class EurekaClientApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	/*
	 *extends WebMvcConfigurationSupport
	 * 
	 * @Override
	 * //在springboot入口的Application文件中增加WebMvc配置，首先继承WebMvcConfigurationSupport类，
	 * 然后重写addResourceHandlers方法，在里面增加对/css路径和/js路径的映射。也可以在application.yml里配置，
	 * 那是另一种方法 protected void addResourceHandlers(ResourceHandlerRegistry registry)
	 * { registry.addResourceHandler("/css/**")
	 * .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/css/");
	 * registry.addResourceHandler("/js/**").addResourceLocations(ResourceUtils.
	 * CLASSPATH_URL_PREFIX + "/static/js/"); super.addResourceHandlers(registry); }
	 */

}
