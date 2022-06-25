package spring.bappy.domain;

import lombok.Data;
import spring.bappy.service.account.User;

@Data
public class UserDto {
    private String userId;
    private String userName;
    private String userGender;
    private String userBirth;
    private String userNation;
    private String userUniversity;
    private String userCharacter;
    private String userLanguage;
    private String userProfile;
    private String userImageUrl;
    private String userThumbnailImageUrl;
    private String userPastHangout;
    private String userLikeHangout;
    private String userMyHangout;
    private int userJoinCount;
    private int userCancelCount;
    private int userMakeCount;

    // 처음 회원가입할 때 받는거
    /*
     * userId
     * userName
     * userGender
     * userBirth
     * userNation
     * ------------- 기본 세팅 -----
     * userMade
     * userJoin
     * userCancel
     * userUniversity
     * userCharacter
     * userHobby
     * userLanguage
     * userProfile
     * userImageUrl
     */

    public User toCreateUser() {
        User user = new User();
        // --- 처음 무조건 설정
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserGender(userGender);
        user.setUserBirth(userBirth);
        user.setUserNation(userNation);
        // ---- 프로필 편집
        user.setUserUniversity("");
        user.setUserCharacter("");
        user.setUserLanguage("");
        user.setUserProfile("");
        user.setUserImageUrl("");
        user.setUserThumbnailImageUrl("");
        // ---- 서비스
        user.setUserPastHangout("");
        user.setUserLikeHangout("");
        user.setUserMyHangout("");
        user.setUserJoinCount(0);
        user.setUserCancelCount(0);
        user.setUserMakeCount(0);

        return user;
    }
    public User toEditUser(User user) {
        if(userUniversity != null)
            user.setUserUniversity(userUniversity);

        if(userCharacter != null)
            user.setUserCharacter(userCharacter);

        if(userLanguage != null)
            user.setUserLanguage(userLanguage);

        if(userProfile != null)
            user.setUserProfile(userProfile);

        if(userImageUrl != null)
            user.setUserImageUrl(userImageUrl);

        if(userThumbnailImageUrl != null)
            user.setUserThumbnailImageUrl(userThumbnailImageUrl);

        return user;


    }

}
