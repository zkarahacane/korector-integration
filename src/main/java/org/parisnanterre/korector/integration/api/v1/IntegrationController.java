package org.parisnanterre.korector.integration.api.v1;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path="/v1")
public class IntegrationController {

    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;


    public IntegrationController(EurekaClient eurekaClient,RestTemplate restTemplate){
        this.eurekaClient = eurekaClient;
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/integrations", method = RequestMethod.GET)
    public ResponseEntity<String> getGroupesViaIntegration(){
       InstanceInfo instance = eurekaClient.getNextServerFromEureka("teams", false);
       String test = restTemplate.getForObject(
               instance.getHomePageUrl() + "/v1/groupes", String.class
       );
       return new ResponseEntity<>(test, HttpStatus.OK);

    }


}
