package spring.bappy.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.bappy.services.account.Account;
import spring.bappy.services.account.AccountRepository;
import spring.bappy.services.dto.UserSaveDto;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    @PostMapping("/account")
    public String makeAccount(UserSaveDto userSaveDto){

        Account accountEntity = accountRepository.save(userSaveDto.toEntity());

        return "abc";
    }

}
