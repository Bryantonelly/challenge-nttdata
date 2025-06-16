package com.nttdata.challenge.personas_clientes_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PersonasClientesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonasClientesMsApplication.class, args);
	}

}
