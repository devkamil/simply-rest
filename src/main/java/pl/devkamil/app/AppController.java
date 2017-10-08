package pl.devkamil.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class AppController {

    @Autowired
    public Content content;

    @GetMapping("/info/")
    public String index() {
        return content.showContent("octocat");
    }
}
