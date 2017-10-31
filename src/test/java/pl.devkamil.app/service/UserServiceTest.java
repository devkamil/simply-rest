package pl.devkamil.app.service;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.devkamil.app.exception.CustomException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void requestOctocatShouldContainStringOctocat() throws Exception{
        this.mockMvc.perform(get("/user/info/octocat")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("octocat")));
    }

    @Test(expected = CustomException.class)
        public void shouldThrownExceptionWhenThisUserNotExist() throws CustomException {
        userService.getUserInfo("RandomLoginOfUserWhichWillNeverExistInGitHub344656");
    }
}
