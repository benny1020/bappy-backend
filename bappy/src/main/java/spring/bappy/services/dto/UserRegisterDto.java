package spring.bappy.services.dto;

import lombok.Data;
import spring.bappy.services.account.User;

@Data
public class UserRegisterDto {
    private String userName;
    private String userId;
    private String userBirth;
    private String userNation;
    private String userGender;

    public User toEntity() {
        User user = new User();
        //user.setUserId(userId);
        user.setUserGender(userGender);
        user.setUserName(userName);
        user.setUserId(userId);
        user.setUserBirth(userBirth);
        user.setUserNation(userNation);
        return user;
    }
}
