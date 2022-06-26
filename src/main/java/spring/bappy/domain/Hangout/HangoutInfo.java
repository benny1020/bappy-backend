package spring.bappy.domain.Hangout;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;

@Document(collection = "hangout_info")
@Data
public class HangoutInfo {

    @Id
    private ObjectId hangoutInfoId;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date hangoutTime;
    private String hangoutTitle;
    private String hangoutImage;
    private String hangoutPlace;

    private ObjectId hangoutPlaceId;
    private ObjectId hangoutJoinId;
    private ObjectId hangoutLikeId;
    private ObjectId hangoutDetailId;
    private ObjectId hangoutCityId;
    private ObjectId hangoutCategoryId;
    private ObjectId hangoutLanguageId;


}
