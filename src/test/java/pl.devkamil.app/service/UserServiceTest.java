package pl.devkamil.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pl.devkamil.app.exception.CustomException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void requestOctocatShouldContainStringOctocat() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/user/info/octocat",
                String.class)).contains("octocat");
    }

    @Test(expected = CustomException.class)
        public void shouldThrownExceptionWhenThisUserNotExist() throws CustomException {
        userService.getUserInfo("RandomLoginOfUserWhichWillNeverExistInGitHub344656");
    }
}
