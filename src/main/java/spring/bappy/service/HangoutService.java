package spring.bappy.service;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.bappy.domain.Hangout.HangoutInfo;
import spring.bappy.repository.HangoutInfoRepository;

import java.io.File;
import java.io.IOException;
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

    public boolean createHangout(HangoutInfo hangoutInfo,String userId, MultipartFile file) {
        hangoutInfo.setHangoutImageUrl(RandomStringUtils.randomAlphabetic(10) + file.getOriginalFilename());
        try {
            File saveFile = new File(System.getProperty("user.dir")+"/src/main/resources/static/HangoutImage/" + hangoutInfo.getHangoutImageUrl());
            file.transferTo(saveFile);

        } catch(IOException e) {
            System.out.println("cant make hangout becauseof image");
            System.out.println(e);
            return false;
        }

        hangoutInfo.setHangoutCurrentNum(0);
        hangoutInfo.setHangoutVisitCount(0);
        hangoutInfo.setHangoutLikeCount(0);
        hangoutInfo.addHangoutUserList(userId);

        hangoutInfoRepository.save(hangoutInfo);

        return true;



    }
}
