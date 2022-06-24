package spring.bappy.domain.User;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_language")
@Data
public class UserLanguage {

    @Id
    private ObjectId userLanguageId;

    private String userLanguage_1;
    private String userLanguage_2;
    private String userLanguage_3;
}
