package spring.bappy.domain.User;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_stat")
@Data
public class UserStat {
    public UserStat()  {
        join = 0;
        made = 0;
        cancelled = 0;
    }
    @Id
    private ObjectId userStatId;

    private int join;
    private int made;
    private int cancelled;



}
