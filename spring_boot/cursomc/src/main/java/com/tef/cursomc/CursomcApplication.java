package com.tef.cursomc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tef.cursomc.services.AwsS3Service;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	//@Autowired
	//private AwsS3Service awsS3Service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Teste no amanzonS3 upload de imagem
		//awsS3Service.uploadFile("C:\\temp\\cactus.jpg");

	}

}
