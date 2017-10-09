package pl.devkamil.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Configuration
@PropertySource("classpath:application.properties")
@Service
public class UserService {

    @Autowired
    private Environment env;

    public String getUserInfo(String login) {

        RestTemplate restTemplate = new RestTemplate();
        final String url = (env.getProperty("spring.datasource.url")) + login;

        User user  = restTemplate.getForObject(url, User.class, new HashMap<>());

        return user.toString();
    }


}
