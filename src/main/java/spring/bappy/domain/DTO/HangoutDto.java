package spring.bappy.domain.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import spring.bappy.domain.Hangout.HangoutDetail;
import spring.bappy.domain.Hangout.HangoutInfo;
import spring.bappy.service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HangoutDto {
    @JsonProperty
    private String hangoutInfoId;
    @JsonProperty
    private String hangoutMeetTime;
    @JsonProperty
    private String hangoutTitle;
    @JsonProperty
    private String hangoutPlan;
    @JsonProperty
    private String hangoutImageUrl;
    @JsonProperty
    private String hangoutLanguage;
    @JsonProperty
    private String hangoutOpenChat;
    @JsonProperty
    private int hangoutTotalNum;
    @JsonProperty
    private int hangoutCurrentNum;
    @JsonProperty
    private int hangoutLikeCount;
    @JsonProperty
    private String hangoutPlaceImageUrl;
    @JsonProperty
    private String hangoutPlaceName;
    @JsonProperty
    private ArrayList<String> hangoutJoinUserId;
    @JsonProperty
    private ArrayList<String> hangoutJoinUserImageUrl;
    @JsonProperty
    private ArrayList<String> hangoutLikeUserId;
    @JsonProperty
    private ArrayList<String> hangoutLikeUserImageUrl;
    @JsonProperty
    private String hangoutStatus;
    @JsonProperty
    private boolean hangoutLikeStatus;
    @JsonProperty
    private boolean hangoutJoinStatus;


    private final UserService userService;

    @Autowired
    public HangoutDto(UserService userService) {
        this.userService = userService;
    }

    public void SetHangoutDto(HangoutInfo hangoutInfo, String userId) {

        hangoutInfoId = hangoutInfo.getHangoutInfoId().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        hangoutMeetTime = simpleDateFormat.format(hangoutInfo.getHangoutMeetTime());
        hangoutTitle = hangoutInfo.getHangoutTitle();
        hangoutPlan = hangoutInfo.getHangoutPlan();
        hangoutImageUrl = hangoutInfo.getHangoutImageUrl();
        hangoutLanguage = hangoutInfo.getHangoutLanguage();
        hangoutOpenChat = hangoutInfo.getHangoutOpenChat();
        hangoutTotalNum = hangoutInfo.getHangoutTotalNum();
        hangoutCurrentNum = hangoutInfo.getHangoutCurrentNum();
        hangoutLikeCount = hangoutInfo.getHangoutLikeCount();
        hangoutPlaceName = hangoutInfo.getHangoutPlace().getPlaceName();
        hangoutPlaceImageUrl = hangoutInfo.getHangoutPlace().getPlaceImageUrl();
        hangoutJoinUserId = hangoutInfo.getHangoutUserList();
        hangoutLikeUserId = hangoutInfo.getHangoutLikeList();
        hangoutJoinStatus = hangoutJoinUserId.contains(userId);
        hangoutLikeStatus = hangoutLikeUserId.contains(userId);

        //closed expired open
        hangoutStatus = "open";
        if(hangoutTotalNum == hangoutCurrentNum)
            hangoutStatus = "closed";
        if(hangoutInfo.getHangoutMeetTime().before(new Date()) )
            hangoutStatus = "expired";

        hangoutJoinUserImageUrl = userService.getUserProfileImageList(hangoutJoinUserId);
        hangoutLikeUserImageUrl = userService.getUserProfileImageList(hangoutLikeUserId);


    }

}
