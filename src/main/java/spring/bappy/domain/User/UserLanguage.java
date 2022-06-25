package spring.bappy.domain.User;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_language")
@Data
public class UserLanguage {

    public UserLanguage() {
        userLanguage_1 = "";
        userLanguage_2 = "";
        userLanguage_3 = "";
    }
    @Id
    private ObjectId userLanguageId;

    private String userLanguage_1;
    private String userLanguage_2;
    private String userLanguage_3;
}
