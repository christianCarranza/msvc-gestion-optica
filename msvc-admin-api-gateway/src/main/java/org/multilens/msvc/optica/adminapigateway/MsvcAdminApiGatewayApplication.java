package org.multilens.msvc.optica.adminapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsvcAdminApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcAdminApiGatewayApplication.class, args);
	}

}
