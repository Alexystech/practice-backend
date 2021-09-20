package com.practice.slasher.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración para trabajar con {@link io.swagger.models.Swagger}
 * con la finalidad de hacer una documentación de fácil
 * visualización para un desarrollador frontend.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Se le indica a {@code Swagger} que el api se
     * encuentra en {@code com.practice.slasher.restapi}
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.practice.slasher.restapi"))
                .build();
    }

}
