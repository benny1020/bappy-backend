package spring.bappy.domain.Hangout;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hangout_place")
@Data
public class HangoutPlace {

    @Id
    private ObjectId hangoutPlaceId;

    private float placeLatitude;
    private float placeLongitude;

}
