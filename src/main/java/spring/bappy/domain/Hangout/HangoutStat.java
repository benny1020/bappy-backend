package spring.bappy.domain.Hangout;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "hangout_stat")
@Data
public class HangoutStat {

    private ObjectId hangoutStatId;
    private ObjectId hangoutInfoId;

    private int hangoutLikeCount;
    private int hangoutVisitCount;
    private List<ObjectId> hangoutLikeList;
}
