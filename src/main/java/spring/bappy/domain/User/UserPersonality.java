package spring.bappy.domain.User;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_personality")
@Data
public class UserPersonality {
    
    public UserPersonality() {
        spontaneous = false;
        planning = false;
        talkative = false;
        shy = false;
        empathetic = false;
        calm = false;
        polite = false;
    }
    @Id
    private ObjectId userPersonalityId;

    private boolean spontaneous;
    private boolean planning;
    private boolean talkative;
    private boolean shy;
    private boolean empathetic;
    private boolean calm;
    private boolean polite;
}
