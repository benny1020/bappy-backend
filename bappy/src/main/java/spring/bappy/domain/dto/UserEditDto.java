package spring.bappy.domain.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
public class UserEditDto {
    private String userUniversity;
    private String userCharacter;
    private String userLanguage;
    private String userProfile;
    private String userImageUrl;
    private String userThumbnailImageUrl;
    private String userPastHangout;
    private String userLikeHangout;
    private String userMyHangout;
}
