package br.com.vbruno.travelassistant;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Assistente de Viagens", version = "1", description = "API desenvolvida para auxiliar no planejamento de viagens"))
public class TravelassistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelassistantApplication.class, args);
	}

}
