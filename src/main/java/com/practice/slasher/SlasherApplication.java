package com.practice.slasher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Esta API REST se conecta a un servidor en una máquina virtual en el id
 * 192.168.1.80 en el puerto 3306.
 *
 * @author Maria de Guadalupe Hernandez Gomez
 * @author Jose Alexis Vazquez Morales
 * @since java 8
 */
@SpringBootApplication
public class SlasherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlasherApplication.class, args);
	}

	/**
	 * Configuración para desactivar los CORS para permitir conectar este
	 * backend con el frontend desarrollado con Angular el cual se
	 * despliega en localhost por el puerto 4200.
	 *
	 * @return WebMvcConfigurer
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

}
