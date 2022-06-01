package spring.bappy.services.dto;

import lombok.Data;
import spring.bappy.services.account.Account;

@Data
public class UserSaveDto {
    private String name;
    private String password;

    public Account toEntity() {
        Account account  = new Account();
        //account.setId(name);
        account.setEmail(password);
        account.setUsername(name);
        return account;
    }
}
