package spring.bappy.domain.DTO;


import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;

@Data
public class UserDto {

    private ObjectId userInfoId;
    private String userId;
    private String userName;
    private String userNationality;
    private String userGender;
    private String userBirth;
    private String userAffiliation;
    private String userIntroduce;
    private String userProfileImageUrl;

    private Boolean userGPS;
    private String userState;

    private ArrayList<String> userLanguages;
    private ArrayList<String> userPersonalities;
    private ArrayList<String> userInterests;



}
