package pl.devkamil.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/info/{login}")
    public @ResponseBody User userInfo(@PathVariable String login) {
        return userService.getUserInfo(login);
    }
}
