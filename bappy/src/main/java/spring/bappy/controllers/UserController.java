package spring.bappy.controllers;
import io.netty.handler.codec.http.HttpStatusClass;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bappy.services.account.User;
import spring.bappy.repositories.AccountRepository;
import spring.bappy.domain.dto.UserDto;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final AccountRepository accountRepository;

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable String userId) {
        User user = accountRepository.findByUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createUser( UserDto userDto) {
        accountRepository.save(userDto.toCreateUser());
        return new ResponseEntity<>("Register Success",HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity editUser(UserDto userDto) {
        String objectId = "62a1f2f3337d9c11372d896f";
        User user = accountRepository.findById(objectId).get();
        userDto.toEditUser(user);
        accountRepository.save(user);

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
