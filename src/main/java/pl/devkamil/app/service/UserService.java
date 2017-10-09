package pl.devkamil.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.devkamil.app.exception.CustomException;
import pl.devkamil.app.model.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Configuration
@PropertySource("classpath:application.properties")
@Service
public class UserService {

    private static final String API_URL_PROPERTIES = "github.api.user.url";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private String url;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        url = (env.getProperty(API_URL_PROPERTIES));
    }


    public User getUserInfo(String login) throws CustomException {

        try {
            RestTemplate restTemplate = new RestTemplate();
            final String urlWithLogin = url + login;

            User user = restTemplate.getForObject(urlWithLogin, User.class, new HashMap<>());
            LOGGER.debug("Result from GitHubAPI: {}", user);
            return user;

        } catch (HttpClientErrorException ex) {
            LOGGER.error("Error while connecting to GitHubAPI: ", ex);
            HttpStatus httpStatus = ex.getStatusCode();
            String message = ex.getMessage();

            throw new CustomException(httpStatus, message);

        } catch (Exception ex) {
            LOGGER.error("Error while connecting to GitHubAPI: ", ex);
            String message = ex.getMessage();

            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
    }
}
