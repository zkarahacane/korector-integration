package org.parisnanterre.korector.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class IntegrationApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean("ribbon-template")
	@LoadBalanced
	public RestTemplate restTemplateWithRibbon() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

}
