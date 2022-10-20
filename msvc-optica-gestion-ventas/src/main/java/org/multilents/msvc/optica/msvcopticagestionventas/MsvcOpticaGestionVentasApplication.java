package org.multilents.msvc.optica.msvcopticagestionventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@RefreshScope
@SpringBootApplication
public class MsvcOpticaGestionVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcOpticaGestionVentasApplication.class, args);
	}

}
