package spring.bappy.domain.User;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_personality")
@Data
public class UserPersonality {

    @Id
    private ObjectId userPersonalityId;

    private boolean spontaneous;
    private boolean planning;
    private boolean talkative;
    private boolean shy;
    private boolean empathatic;
    private boolean calm;
    private boolean polite;
}
