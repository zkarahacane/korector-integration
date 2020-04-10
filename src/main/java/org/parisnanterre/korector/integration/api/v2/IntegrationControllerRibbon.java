package org.parisnanterre.korector.integration.api.v2;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(path="/v2")
public class IntegrationControllerRibbon {

    protected String url = "http://teams";
    private final RestTemplate restTemplate;


    public IntegrationControllerRibbon(@Qualifier("ribbon-template") RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/integrations", method = RequestMethod.GET)
    public ResponseEntity<String> getGroupesViaIntegration(){
        String test = restTemplate.getForObject(
                url + "/v1/groupes", String.class
        );
        return new ResponseEntity<>(test, HttpStatus.OK);

    }


}
