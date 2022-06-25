package spring.bappy.service.account;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class User {
    @Id
    private ObjectId objectId;

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

}
