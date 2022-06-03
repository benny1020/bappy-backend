package spring.bappy.controllers;
import com.google.firebase.auth.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.bappy.services.account.User;
import spring.bappy.repositories.AccountRepository;
import spring.bappy.services.dto.UserEditDto;
import spring.bappy.services.dto.UserRegisterDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final AccountRepository accountRepository;

    @PostMapping("")
    public String createUser(@RequestBody UserRegisterDto userRegisterDto) {
        accountRepository.save(userRegisterDto.toEntity());
        return "success";
    }

    @PutMapping("")
    public String editUser(@RequestBody UserEditDto userEditDto) {

    }
    @PostMapping("")
    public String makeAccount(UserRegisterDto userRegisterDto) throws FirebaseAuthException {

        User userEntity = accountRepository.save(userRegisterDto.toEntity());
        try{
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(userRegisterDto.getUserName());
            String uid = decodedToken.getUid();
            System.out.println("uid : " + uid);
        } catch(FirebaseAuthException e) {
            System.out.println("error");
        }



        return "abc";
    }
    @GetMapping("/test")
    public String test() {
        System.out.println("kkkkkkkkkkkkkkkkkk");
        return "abc + asdsd";
    }
    @GetMapping("/account")
    public User getAccount() throws FirebaseAuthException {
        System.out.println("kkkkkkkkkkkkkkkkkk");

        ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
        while (page != null) {
            for (ExportedUserRecord user : page.getValues()) {
                System.out.println("User: " + user.getUid());
                System.out.println("User token: " + user.getTokensValidAfterTimestamp());
            }
            page = ((ListUsersPage) page).getNextPage();
        }

// Iterate through all users. This will still retrieve users in batches,
// buffering no more than 1000 users in memory at a time.
        User user = new User();
        return user;
    }


}
