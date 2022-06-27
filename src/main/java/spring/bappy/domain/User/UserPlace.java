package spring.bappy.domain.User;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import spring.bappy.domain.Place;

import java.util.ArrayList;

@Document(collection = "user_place")
@Data
public class UserPlace {


    @Id
    private ObjectId userPlaceId;

    private Boolean userGPS;
    private ArrayList<Place> userPlaceList;

    public UserPlace() {
        userGPS = false;
    }

}
