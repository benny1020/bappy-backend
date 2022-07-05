package spring.bappy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bappy.controllers.response.Message;
import spring.bappy.controllers.response.StatusEnum;
import spring.bappy.domain.Place;
import spring.bappy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/place")
public class PlaceController {
    private final UserService userService;

    @Autowired
    public PlaceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    ResponseEntity getUserPlaceList(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        ArrayList<Place> userPlaceList = userService.getUserPlaces(userId);

        Message message = new Message();
        message.setMessage("it is user place list");
        message.setStatus(StatusEnum.OK);
        message.setData(userPlaceList);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity setUserPlace(@RequestParam Place place,HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        userService.addUserPlace(place, userId);

        Message message = new Message();
        message.setMessage("add the place");
        message.setStatus(StatusEnum.OK);
        message.setData(true);

        return new ResponseEntity<>(message, HttpStatus.OK);

    }
    @PutMapping("")
    public ResponseEntity removeUserPlace(@RequestParam Place place, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        userService.removeUserPlace(place,userId);
        Message message = new Message();
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);

    }

    @PutMapping("/gps")
    public ResponseEntity setGPS(@RequestParam boolean gps, HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        userService.setUserGPS(userId, gps);
        Message message = new Message();
        message.setData(true);
        message.setMessage("set success  " + gps);
        message.setStatus(StatusEnum.OK);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/gps")
    public ResponseEntity getGPS(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        boolean gps = userService.getUserGPS(userId);
        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setData(gps);
        message.setMessage("현재 gps 상태 : " + gps);
        return new ResponseEntity<>(message, HttpStatus.OK);


    }
}
