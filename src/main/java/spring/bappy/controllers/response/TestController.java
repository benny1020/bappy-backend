package spring.bappy.controllers.response;


import com.google.firebase.database.annotations.NotNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.bappy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/test")
public class TestController {

    private final UserService userService;

    @Autowired
    TestController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("")
    public String test(HttpServletRequest request) {
        ObjectId ans = userService.getUserObjectId((String)request.getAttribute("userId"));
        System.out.println(ans);
        return ans.toString();
    }
}
