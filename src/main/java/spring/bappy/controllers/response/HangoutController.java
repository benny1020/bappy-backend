package spring.bappy.controllers.response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bappy.domain.Hangout.HangoutInfo;
import spring.bappy.service.HangoutService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hangout")
public class HangoutController {

    private final HangoutService hangoutService;

    @Autowired
    public HangoutController(HangoutService hangoutService) {
        this.hangoutService = hangoutService; }

    @PostMapping("")
    public ResponseEntity createHangout(HangoutInfo hangoutInfo, HttpServletRequest request) {
        String userId = (String)request.getAttribute("userId");

        hangoutService.createHangout(hangoutInfo, userId);
        Message message = new Message();
        message.setMessage("create hangout success");
        message.setData(true);
        message.setStatus(StatusEnum.OK);

        return new ResponseEntity(message,HttpStatus.OK);
    }

    @PutMapping("/like/{hangoutInfoId}")
    public ResponseEntity likeHangout(@PathVariable String hangoutInfoId, HttpServletRequest request) {
        String userId = (String)request.getAttribute("userId");
        System.out.println(hangoutInfoId);

        hangoutService.likeHangout(hangoutInfoId, userId);
        Message message = new Message();
        message.setMessage("like");
        message.setData(true);
        message.setStatus(StatusEnum.OK);

        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }

    @PutMapping("/noLike/{hangoutInfoId}")
    public ResponseEntity noLikeHangout(@PathVariable String hangoutInfoId, HttpServletRequest request) {
        String userId = (String)request.getAttribute("userId");
        hangoutService.noLikeHangout(hangoutInfoId, userId);
        Message message = new Message();
        message.setMessage("no like");
        message.setData(true);
        message.setStatus(StatusEnum.OK);
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }


}
