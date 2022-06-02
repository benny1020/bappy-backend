package spring.bappy.controllers;
import com.google.firebase.auth.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.bappy.services.account.Account;
import spring.bappy.services.account.AccountRepository;
import spring.bappy.services.dto.UserSaveDto;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    @PostMapping("/account")
    public String makeAccount(UserSaveDto userSaveDto) throws FirebaseAuthException {

        Account accountEntity = accountRepository.save(userSaveDto.toEntity());
        System.out.println(userSaveDto.getName());
        System.out.println(userSaveDto.getPassword());
        try{
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IjM4ZjM4ODM0NjhmYzY1OWFiYjQ0NzVmMzYzMTNkMjI1ODVjMmQ3Y2EiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMjA2MjE3Njc5MTAtdHNycWpqcjZzY2UxMWxuM3E0aTlnOWJxdTIyNDFuZWQuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIxMjA2MjE3Njc5MTAtdHNycWpqcjZzY2UxMWxuM3E0aTlnOWJxdTIyNDFuZWQuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTIxNDEzMTc4NjcyODY5ODIxNTAiLCJlbWFpbCI6Im51cGljN0BnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6IlBha3ZRcFlhcG1wYmloYVBYb3dYY3ciLCJub25jZSI6IlRuVXo2NU1hWThIOWtOc2lkelhBcDFCdVJmZWN4UF85STF5OExIdFZ5aEUiLCJuYW1lIjoi7Kad65Ox7LikIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hLS9BT2gxNEdqZWxRUWlHTWcwUTZyT1dxOWlyWU9DeFlnTEpQNXJrMVRhSkxUVEVnPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6IuuTsey4pCIsImZhbWlseV9uYW1lIjoi7KadIiwibG9jYWxlIjoia28iLCJpYXQiOjE2NTQxNzQ1MDQsImV4cCI6MTY1NDE3ODEwNH0.V6ah8-QBzijrnBFC27WEgvt6UF0m6C17qmbuwGxmLwMN_vCxGMycQD3hKRQP2Dd947LwQQ1ACRvKkN2uQK5L-46-zTvm_fvSsUKc5853j-Wx18dZAxSMkcnSzaBG_z_ydWcF1om-FGflcJ0UtmBfN6vG0JInlX2z-xKGWjcWky5zOJpdF5SZFYZX_AKVpURHplliGMDE_mGlCXdCk6RNo713j6Q9PrbXWLmEDm_SqkVxI4nZqoXJDkMFXW670Xdyr-UaqXxP2gv_Cc29Z36viQ0JWq-anm9faGmizVRbpSTz5YCF_wVGGR4kO-oRXOUH7qqHKdTuEIYOIX80TpVoOA");
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
    public Account getAccount() throws FirebaseAuthException {
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
        Account account = new Account();
        account.setUsername("asdd");
        account.setId("id");
        account.setEmail("email");
        return account;
    }


}
