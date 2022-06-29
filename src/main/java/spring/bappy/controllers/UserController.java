package spring.bappy.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bappy.controllers.response.Message;
import spring.bappy.controllers.response.StatusEnum;
import spring.bappy.domain.DTO.UserDto;
import spring.bappy.domain.User.UserDetail;
import spring.bappy.domain.User.UserInfo;
import spring.bappy.service.UserService;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;



    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public ResponseEntity getUser() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable String userId) {
        //User user = accountRepository.findByUserId(userId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("")
    public ResponseEntity createUser(UserInfo userInfo,HttpServletRequest request) {


        String userId = (String)request.getAttribute("userId");
        userInfo.setUserId(userId);
        boolean res = userService.createUser(userInfo);
        UserDto userDto = userService.getUserDto(userId);
        Message message = new Message();


        if(res) {
            message.setStatus(StatusEnum.OK);
            message.setMessage("create user success");
            userDto.setUserState("normal");

        } else {
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("create user failed");
            userDto.setUserState("notRegistered");
        }
        message.setData(userDto);

        return new ResponseEntity<>(message,HttpStatus.OK);




    }

    @PutMapping("")
    public ResponseEntity editUser(UserDetail userDetail,HttpServletRequest request) {

        String userId = (String)request.getAttribute("userId");
        boolean res = userService.editUser(userId,userDetail);
        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        if(res) {
            message.setData(true);
            message.setMessage("edit success");
        } else {
            message.setData(false);
            message.setMessage("edit failed");
        }

        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/gps")
    public ResponseEntity setGPS(@RequestParam boolean gps, HttpServletRequest request) {
        String userId = (String)request.getAttribute("userId");
        userService.setUserGPS(userId,gps);
        Message message = new Message();
        message.setData(true);
        message.setMessage("set success  " + gps);
        message.setStatus(StatusEnum.OK);

        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @GetMapping("/gps")
    public ResponseEntity getGPS(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        boolean gps = userService.getUserGPS(userId);
        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setData(gps);
        message.setMessage("현재 gps 상태 : "+gps);
        return  new ResponseEntity<>(message,HttpStatus.OK);

    }

//    @PostMapping("")
//    public String createAccount(UserRegisterDto userRegisterDto) throws FirebaseAuthException {
//
//        User userEntity = accountRepository.save(userRegisterDto.toEntity());
//        try{
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(userRegisterDto.getUserName());
//            String uid = decodedToken.getUid();
//            System.out.println("uid : " + uid);
//        } catch(FirebaseAuthException e) {
//            System.out.println("error");
//        }
//
//
//
//        return "abc";
//    }
//    @DeleteMapping
//    public String deleteUser() {
//
//    }
//    @GetMapping("/")
//    public String getAccount() throws FirebaseAuthException {
//        //System.out.println("kkkkkkkkkkkkkkkkkk");
//        List<User> users =  accountRepository.findAll();
//        for(User u : users) {
//            System.out.println(u.getObjectId());
//        }
//
//
////        ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
////        while (page != null) {
////            for (ExportedUserRecord user : page.getValues()) {
////                System.out.println("User: " + user.getUid());
////                System.out.println("User token: " + user.getTokensValidAfterTimestamp());
////            }
////            page = ((ListUsersPage) page).getNextPage();
////        }
//
//// Iterate through all users. This will still retrieve users in batches,
//// buffering no more than 1000 users in memory at a time.
//        //User user = new User();
//        return "user";
   // }


}
