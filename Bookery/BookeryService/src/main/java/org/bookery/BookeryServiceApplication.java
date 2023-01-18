package org.bookery;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "org.bookery.models")
public class BookeryServiceApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(BookeryServiceApplication.class, args);
	}
}