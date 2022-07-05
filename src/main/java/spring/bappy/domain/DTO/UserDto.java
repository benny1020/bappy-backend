package spring.bappy.domain.DTO;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import spring.bappy.domain.Place;
import spring.bappy.domain.User.UserDetail;
import spring.bappy.domain.User.UserInfo;
import spring.bappy.domain.User.UserPlace;
import spring.bappy.repository.UserDetailRepository;
import spring.bappy.repository.UserPlaceRepository;

import java.util.ArrayList;

@Data
public class UserDto {

    private String userInfoId;
    private String userId;
    private String userName;
    private String userNationality;
    private String userGender;
    private String userBirth;
    private String userAffiliation;
    private String userIntroduce;
    private String userProfileImageUrl;
    private String userNationalityCode;
    private Place userCheckPlace;

    private Boolean userGPS;
    private String userState;

    private ArrayList<String> userLanguages;
    private ArrayList<String> userPersonalities;
    private ArrayList<String> userInterests;

}
