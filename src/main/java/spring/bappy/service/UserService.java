package spring.bappy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import spring.bappy.domain.DTO.UserDto;
import spring.bappy.domain.Place;
import spring.bappy.domain.User.*;
import spring.bappy.repository.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserInfoRepository userInfoRepository;
    private final UserDetailRepository userDetailRepository;
    private final UserStatRepository userStatRepository;
    private final UserPlaceRepository userPlaceRepository;



    public boolean createUser(UserInfo userInfo) {
        System.out.println("uid : " + userInfo.getUserId());
        try {
            UserDetail userDetail = new UserDetail();
            UserPlace userPlace = new UserPlace();
            UserStat userStat = new UserStat();

            userInfo.setUserDetailId(userDetailRepository.save(userDetail).getUserDetailId());
            userInfo.setUserStatId(userStatRepository.save(userStat).getUserStatId());
            userInfo.setUserPlaceId(userPlaceRepository.save(userPlace).getUserPlaceId());

            userInfoRepository.save(userInfo);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public UserDto getUserDto(String userId) {
        UserDto userDto = new UserDto();
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        UserDetail userDetail = userDetailRepository.findUserDetailByUserDetailId(userInfo.getUserDetailId());
        UserPlace userPlace = userPlaceRepository.findUserPlaceByUserPlaceId(userInfo.getUserPlaceId());
        userDto.setUserId(userId);
        userDto.setUserInfoId(userInfo.getUserInfoId());
        userDto.setUserName(userInfo.getUserName());
        userDto.setUserNationality(userInfo.getUserNationality());
        userDto.setUserGender(userInfo.getUserGender());
        userDto.setUserBirth(userInfo.getUserBirth());
        userDto.setUserAffiliation(userDetail.getUserAffiliation());
        userDto.setUserIntroduce(userDetail.getUserIntroduce());
        userDto.setUserProfileImageUrl(userDetail.getUserProfileImageUrl());
        userDto.setUserGPS(userPlace.getUserGPS());
        userDto.setUserLanguages(userDetail.getUserLanguages());
        userDto.setUserPersonalities(userDetail.getUserPersonalities());
        userDto.setUserInterests(userDetail.getUserInterests());

        return userDto;


    }

    public boolean editUser(String userId, @RequestParam UserDetail userDetail){
        try {
            System.out.println(userId);
            userDetail.setUserDetailId(userInfoRepository.findUserInfoByUserId(userId).getUserDetailId());
            userDetailRepository.save(userDetail);
        } catch(Exception e) {
            return false;
        }
        return true;

    }



    public boolean isUser(String userId)  {

        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        if(userInfo == null)
            return false;
        else
            return true;
    }

    public ObjectId getUserObjectId(String userId) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        return userInfo.getUserInfoId();
    }

    public ArrayList<Place> getUserPlaces(String userId) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        UserPlace userPlace = userPlaceRepository.findUserPlaceByUserPlaceId(userInfo.getUserPlaceId());
        return userPlace.getUserPlaceList();
    }

    public boolean addUserPlace(Place place, String userId) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        UserPlace userPlace = userPlaceRepository.findUserPlaceByUserPlaceId(userInfo.getUserPlaceId());

        ArrayList<Place> placeList = userPlace.getUserPlaceList();
        placeList.add(place);

        userPlace.setUserPlaceList(placeList);
        userPlaceRepository.save(userPlace);
        return true;
    }
    public boolean removeUserPlace(Place place, String userId) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        UserPlace userPlace = userPlaceRepository.findUserPlaceByUserPlaceId(userInfo.getUserPlaceId());

        ArrayList<Place> placeList = userPlace.getUserPlaceList();
        placeList.remove(place);

        userPlace.setUserPlaceList(placeList);
        userPlaceRepository.save(userPlace);
        return true;
    }

    public boolean getUserGPS(String userId) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        UserPlace userPlace = userPlaceRepository.findUserPlaceByUserPlaceId(userInfo.getUserPlaceId());

        return userPlace.getUserGPS();
    }

    public boolean setUserGPS(String userId, boolean status) {
        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        UserPlace userPlace = userPlaceRepository.findUserPlaceByUserPlaceId(userInfo.getUserPlaceId());

        userPlace.setUserGPS(status);
        userPlaceRepository.save(userPlace);
        return true;
    }


}
