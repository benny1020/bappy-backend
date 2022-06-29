package spring.bappy.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bappy.domain.Hangout.HangoutInfo;
import spring.bappy.repository.HangoutInfoRepository;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class HangoutService {

    private final HangoutInfoRepository hangoutInfoRepository;

    public boolean likeHangout(String hangoutInfoId, String userId) {
        HangoutInfo hangoutInfo = hangoutInfoRepository.findHangoutInfoByHangoutInfoId(hangoutInfoId);
        hangoutInfo.addHangoutLikeList(userId);
        hangoutInfoRepository.save(hangoutInfo);
        return true;
    }

    public boolean noLikeHangout(String hangoutInfoId, String userId) {

        HangoutInfo hangoutInfo = hangoutInfoRepository.findHangoutInfoByHangoutInfoId(hangoutInfoId);
        hangoutInfo.removeHangoutLikeList(userId);
        hangoutInfoRepository.save(hangoutInfo);
        return true;
    }

    public boolean createHangout(HangoutInfo hangoutInfo,String userId) {
        hangoutInfo.setHangoutCurrentNum(0);
        hangoutInfo.setHangoutVisitCount(0);
        hangoutInfo.setHangoutLikeCount(0);
        hangoutInfo.addHangoutUserList(userId);

        hangoutInfoRepository.save(hangoutInfo);

        return true;



    }
}
