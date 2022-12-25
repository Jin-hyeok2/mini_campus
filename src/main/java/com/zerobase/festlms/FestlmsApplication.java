package com.zerobase.festlms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FestlmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FestlmsApplication.class, args);
	}

}
