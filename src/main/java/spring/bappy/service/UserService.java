package spring.bappy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bappy.domain.User.*;
import spring.bappy.repository.*;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserInfoRepository userInfoRepository;
    private final UserDetailRepository userDetailRepository;
    private final UserInterestsRepository userInterestsRepository;
    private final UserLanguageRepository userLanguageRepository;
    private final UserPersonalityRepository userPersonalityRepository;
    private final UserStatRepository userStatRepository;


    public boolean createUser(UserInfo userInfo) {
        System.out.println("uid : " + userInfo.getUserId());
        try {
            UserDetail userDetail = new UserDetail();
            UserPersonality userPersonality = new UserPersonality();
            UserLanguage userLanguage = new UserLanguage();
            UserIntersts userIntersts = new UserIntersts();
            UserStat userStat = new UserStat();

            userInfo.setUserDetailId(userDetailRepository.save(userDetail).getUserDetailId());
            userInfo.setUserPersonalityId(userPersonalityRepository.save(userPersonality).getUserPersonalityId());
            userInfo.setUserLanguageId(userLanguageRepository.save(userLanguage).getUserLanguageId());
            userInfo.setUserInterestsId(userInterestsRepository.save(userIntersts).getUserInterstsId());
            userInfo.setUserStatId(userStatRepository.save(userStat).getUserStatId());

            userInfoRepository.save(userInfo);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    public boolean isUser(String userId)  {

        UserInfo userInfo = userInfoRepository.findUserInfoByUserId(userId);
        if(userInfo == null)
            return false;
        else
            return true;
    }


}
