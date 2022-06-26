package spring.bappy.domain.Hangout;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hangout_category")
@Data
public class HangoutCategory {

    @Id
    private ObjectId hangoutCategoryId;

    private ObjectId hangoutInfoId;

    private boolean travel;
    private boolean study;
    private boolean volunteer;
    private boolean sports;
    private boolean food;
    private boolean drinks;
    private boolean cook;
    private boolean crafting;
    private boolean culturalActivities;
    private boolean practiceLanguage;

}
