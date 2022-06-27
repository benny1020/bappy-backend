package spring.bappy.domain.User;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "user_detail")
@Data
public class UserDetail {
    public UserDetail() {

        userIntroduce = "";
        userAffiliation = "";

    }
    @Id
    private ObjectId userDetailId;

    private String userProfileImageUrl;
    private String userIntroduce;
    private String userAffiliation;

    private ArrayList<String> userLanguages;
    private ArrayList<String> userInterests;
    private ArrayList<String> userPersonalities;



            
            
}
