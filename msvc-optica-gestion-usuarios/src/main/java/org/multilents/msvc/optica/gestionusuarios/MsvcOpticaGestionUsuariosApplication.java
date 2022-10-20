package org.multilents.msvc.optica.gestionusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//para el resttemplate
@SpringBootApplication
public class MsvcOpticaGestionUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcOpticaGestionUsuariosApplication.class, args);
	}

}
