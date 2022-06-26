package spring.bappy.domain.Hangout;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hangout_city")
@Data
public class HangoutCity {

    @Id
    private ObjectId hangoutCityId;

    private ObjectId hangoutInfoId;

    private String hangoutCity;
}
