package com.kartik.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.kartik.demo.entity.Employee;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
//		RestTemplate restTemplate = new RestTemplate();
//		
//		String baseUrl="http://localhost:8080/employee"; 
//		
////		HttpEntity<String> request = new HttpEntity<>
//		
//		String request = "{\"name\":\"Kartik Jain\",\"department\":\"IT\",\"age\":22}\n";
//		
//		restTemplate.postForObject(baseUrl+"/createEmployee", request, Employee.class);
	}

}
