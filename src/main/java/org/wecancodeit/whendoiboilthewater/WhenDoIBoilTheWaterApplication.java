package org.wecancodeit.whendoiboilthewater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhenDoIBoilTheWaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhenDoIBoilTheWaterApplication.class, args);
		System.out.println("Server is Running!");
	}
}
