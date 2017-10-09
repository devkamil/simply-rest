package pl.devkamil.app;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class Content {

    public String showContent(String login) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://api.github.com/users/" + login;

        RestContent restContent = restTemplate.getForObject(url, RestContent.class, new HashMap<>());

        return restContent.toString();
    }
}
