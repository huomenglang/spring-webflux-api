package com.menglang.spring_webflux.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;

import java.util.Collections;
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .servers(Collections.emptyList())
                .info(new Info().title("Sample WebFlux API")
                        .version("1.0.0")
                        .description("API for my WebFlux project")
                        .contact(new Contact()
                                        .name("MengLang")
                                        .email("support@example.com")
                                        .url("https://example.com"))
                        .license(new License()
                                .name("Alpha Dev 1.0")
                                .url("https://www.menglang.org/licenses/LICENSE-2.0")));
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler(new String[] {"/swagger-ui.html***"})
//                .addResourceLocations(new String[] {"classpath:/resources/swagger-ui.html"});
//    }
}
