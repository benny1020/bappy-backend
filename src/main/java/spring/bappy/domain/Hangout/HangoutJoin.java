package spring.bappy.domain.Hangout;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "hangout_join")
@Data
public class HangoutJoin {

    @Id
    private ObjectId hangoutJoinId;

    private ObjectId hangoutInfoId;

    private List<ObjectId> hangoutParticipantsList;
    private int hangoutTotal;
    private int hangoutCurrent;


}
