package spring.bappy.controllers;


import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.bappy.controllers.response.Message;
import spring.bappy.controllers.response.StatusEnum;
import spring.bappy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) { this.userService =  userService;}



    @RequestMapping("revoke")
    public ResponseEntity revoke() {
        System.out.println("it is revoke");
        Message message = new Message();
        message.setMessage("it is revoked token");
        message.setStatus(StatusEnum.REVOKED_ID_TOKEN);
        message.setToken(1);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @RequestMapping("invalid")
    public ResponseEntity invalid() {
        System.out.println("it is invalid");
        Message message = new Message();
        message.setMessage("it is invalid token");
        message.setStatus(StatusEnum.INVALID_ID_TOKEN);
        message.setToken(-1);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @RequestMapping("login")
    public ResponseEntity login(HttpServletRequest request) {

        String userId = (String)request.getAttribute("userId");

        Message message = new Message();
        boolean res = userService.isUser(userId);
        message.setStatus(StatusEnum.OK);
        if(res) {
            message.setData(true);
            message.setMessage("already user");
        } else {
            message.setMessage("new user");
            message.setData(false);
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }



}
