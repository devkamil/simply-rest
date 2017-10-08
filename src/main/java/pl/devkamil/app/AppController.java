package pl.devkamil.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get/user/info/")
public class AppController {

    @Autowired
    public Content content;

    @RequestMapping("/")
    public String index() {
        return content.login;
    }
}
