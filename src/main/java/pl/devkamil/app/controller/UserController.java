package pl.devkamil.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.devkamil.app.error.CustomError;
import pl.devkamil.app.exception.CustomException;
import pl.devkamil.app.model.User;
import pl.devkamil.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/info/{login}")
    public @ResponseBody
    ResponseEntity userInfo(@PathVariable String login) {
        User user;
        try {
            user = userService.getUserInfo(login);
        } catch (CustomException ex) {
            CustomError error = new CustomError(ex.getHttpStatus().value(), ex.getMessage());
            return new ResponseEntity(error, ex.getHttpStatus());
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
