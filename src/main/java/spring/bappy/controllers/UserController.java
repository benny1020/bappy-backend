package spring.bappy.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.bappy.controllers.response.Message;
import spring.bappy.controllers.response.StatusEnum;
import spring.bappy.domain.User.UserInfo;
import spring.bappy.domain.UserDto;
import spring.bappy.service.UserService;
import spring.bappy.service.account.User;
import spring.bappy.repository.AccountRepository;

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

        userInfo.setUserId((String)request.getAttribute("userId"));

        boolean res = userService.createUser(userInfo);
        Message message = new Message();
        boolean result;

        if(res) {
            message.setStatus(StatusEnum.OK);
            message.setMessage("create user success");
            result=true;
        } else {
            message.setStatus(StatusEnum.BAD_REQUEST);
            message.setMessage("create user failed");
            result=false;
        }
        message.setData(result);

        return new ResponseEntity<>(message,HttpStatus.OK);




    }

    @PutMapping("")
    public ResponseEntity editUser(UserDto userDto) {
        //String objectId = "62a1f2f3337d9c11372d896f";
        //User user = accountRepository.findById(objectId).get();
        //userDto.toEditUser(user);
        //accountRepository.save(user);

        return new ResponseEntity<>("Edit Success",HttpStatus.OK);
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
