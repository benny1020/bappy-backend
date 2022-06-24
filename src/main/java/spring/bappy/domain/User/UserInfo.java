package spring.bappy.domain.User;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_info")
@Data
public class UserInfo {
    @Id
    private ObjectId userInfoId;

    private String userSnsId;
    private String userName;
    private String userGender;
    private String userNation;

    // --------- user_detail , personality, language, interests 주소
    private ObjectId userDetailId;
    private ObjectId userPersonalityId;
    private ObjectId userLanguageId;
    private ObjectId userInterestsId;
    private ObjectId userStatId;


}
