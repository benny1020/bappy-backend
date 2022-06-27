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
    private String userId;
    private String userName;
    private String userGender;
    private String userNationality;
    private String userBirth;

    // --------- user_detail , personality, language, interests 주소
    private ObjectId userDetailId;
    private ObjectId userStatId;
    private ObjectId userPlaceId;



}
