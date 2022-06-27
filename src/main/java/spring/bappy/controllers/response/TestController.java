package spring.bappy.controllers.response;


import com.google.firebase.database.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("")
    public ResponseEntity test(@RequestParam ArrayList<String> inp) {
        System.out.println("start");
        for(int i=0;i<inp.size();i++)
            System.out.println(inp.get(i));
        String s = inp.get(0);
        String tmp = "asd";
        System.out.println(tmp);
        System.out.println(s);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
