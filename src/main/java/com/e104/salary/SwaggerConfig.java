package com.e104.salary;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Summer", "待補", "tinghung.wang@104.com.tw");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"薪資報酬", "薪資報酬 Swagger", "1.0",
			"urn:tos", DEFAULT_CONTACT, 
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO);
	}
}