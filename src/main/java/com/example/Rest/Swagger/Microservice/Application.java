package com.example.Rest.Swagger.Microservice;

import com.example.Rest.Swagger.Microservice.model.dto.TaskDTO;
import com.example.Rest.Swagger.Microservice.model.dto.UserDTO;
import com.example.Rest.Swagger.Microservice.service.TaskService;
import com.example.Rest.Swagger.Microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
