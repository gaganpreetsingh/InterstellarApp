package com.gagan;

import javax.xml.ws.Endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gagan.service.soap.PlanetSoapServiceImpl;
import com.gagan.util.ExcelReader;

@SpringBootApplication
@ComponentScan(basePackages = "com.gagan")
@EnableJpaRepositories("com.gagan")
@EntityScan(basePackages = "com.gagan")
public class InterstellarAppApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(InterstellarAppApplication.class);
	
	//Change excel file path in application.properties to load its data
	@Value("${excel.filePath}")
	public String filePath;
	
	public static void main(String[] args) {
		logger.info("Started Spring Boot application");
		SpringApplication.run(InterstellarAppApplication.class, args);
	}

	
	@Override
	public void run(String... arg0) throws Exception {
		//Soap service will be published when Spring Boot app started at 9090 port
		Endpoint.publish("http://localhost:9090/planetService", new PlanetSoapServiceImpl());
		
		
		ExcelReader.saveFileToDB(filePath);		
	}
}