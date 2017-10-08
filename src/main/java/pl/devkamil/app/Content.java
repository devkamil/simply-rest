package pl.devkamil.app;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class Content {

    RestTemplate restTemplate =  new RestTemplate();
    final String url = "https://api.github.com/users/octocat";

    RestContent restContent = restTemplate.getForObject(url, RestContent.class, new HashMap<>());

    String jsonContent = restContent.toString();

}
