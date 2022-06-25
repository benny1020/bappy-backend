package spring.bappy.domain.User;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_detail")
@Data
public class UserDetail {
    public UserDetail() {
        userUniversity = "";
        userProfile = "";
    }
    @Id
    private ObjectId userDetailId;

    private String userUniversity;
    private String userProfile;
}
