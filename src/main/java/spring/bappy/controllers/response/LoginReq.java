package spring.bappy.controllers.response;

import lombok.Data;

@Data
public class LoginReq {
    private String name;
    private String password;
}
