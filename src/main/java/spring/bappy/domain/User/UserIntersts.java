package spring.bappy.domain.User;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_interests")
@Data
public class UserIntersts {
    @Id
    private ObjectId userInterstsId;

    private boolean travel;
    private boolean study;
    private boolean volunteer;
    private boolean cook;
    private boolean food;



}
