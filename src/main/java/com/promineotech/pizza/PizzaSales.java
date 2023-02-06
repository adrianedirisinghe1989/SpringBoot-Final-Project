package com.promineotech.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class PizzaSales {

	
	public static void main(String[] args) {
		SpringApplication.run(PizzaSales.class, args);
		
	}

}
