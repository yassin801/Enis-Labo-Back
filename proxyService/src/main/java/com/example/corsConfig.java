package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class corsConfig {

	/*
	 * @Bean public CorsFilter corsFilter() { final UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource(); final CorsConfiguration
	 * config = new CorsConfiguration(); config.setAllowCredentials(true);
	 * config.setAllowedOrigins(Collections.singletonList(""));
	 * config.setAllowedHeaders(Collections.singletonList(""));
	 * config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::
	 * name).collect(Collectors.toList())); source.registerCorsConfiguration("/**",
	 * config); return new CorsFilter(source); }
	 */

}
