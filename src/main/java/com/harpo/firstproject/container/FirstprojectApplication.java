package com.harpo.firstproject.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author harpo
 * Initial object used to run Application
 *
 */
@SpringBootApplication(scanBasePackages = "com.harpo.firstproject.module")
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
}
