package spring.bappy.domain.Report;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_report")
@Data
public class Report {
    @Id
    private ObjectId reportId;
    private String reportTitle;
    private String reportDetail;
    private String reportImageUrl;
    private String reportUserId;

}
