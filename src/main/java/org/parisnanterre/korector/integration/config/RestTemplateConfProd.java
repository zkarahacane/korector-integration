package org.parisnanterre.korector.integration.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("prod")
public class RestTemplateConfProd {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean("ribbon-template")
    @LoadBalanced
    public RestTemplate restTemplateWithRibbon() {
        return new RestTemplate();
    }
}
