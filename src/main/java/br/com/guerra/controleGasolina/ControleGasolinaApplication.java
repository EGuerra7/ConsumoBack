package br.com.guerra.controleGasolina;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ControleGasolinaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ControleGasolinaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
