package pl.devkamil.app;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class Content {

    RestTemplate rest =  new RestTemplate();
    final String url = "https://api.github.com/users/octocat";
    Map<String, Object> res = rest.getForObject(url, Map.class, new HashMap<>());

    String login = (String) res.get("login");
}
