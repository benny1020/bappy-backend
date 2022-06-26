package spring.bappy.domain.Hangout;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hangout_language")
@Data
public class HangoutLanguage {

    @Id
    private ObjectId hangoutLanguageId;

    private ObjectId hangoutInfoId;

    private String hangoutLanguage;
}
