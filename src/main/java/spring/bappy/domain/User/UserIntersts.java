package spring.bappy.domain.User;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_interests")
@Data
public class UserIntersts {

    public UserIntersts() {
        travel = false;
        study = false;
        volunteer = false;
        cook = false;
        food = false;
    }
    @Id
    private ObjectId userInterestsId;

    private boolean travel;
    private boolean study;
    private boolean volunteer;
    private boolean cook;
    private boolean food;



}
