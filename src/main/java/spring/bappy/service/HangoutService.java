package spring.bappy.service;


import io.opencensus.resource.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.bappy.domain.Hangout.HangoutInfo;
import spring.bappy.repository.HangoutInfoRepository;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public boolean joinHangout(String hangoutInfoId, String userId) {
        HangoutInfo hangoutInfo = hangoutInfoRepository.findHangoutInfoByHangoutInfoId(hangoutInfoId);
        hangoutInfo.addHangoutUserList(userId);
        hangoutInfoRepository.save(hangoutInfo);
        return true;
    }

    public boolean cancelHangout(String hangoutInfoId, String userId) {
        HangoutInfo hangoutInfo = hangoutInfoRepository.findHangoutInfoByHangoutInfoId(hangoutInfoId);
        hangoutInfo.removeHangoutUserList(userId);
        hangoutInfoRepository.save(hangoutInfo);
        return true;
    }

    public boolean createHangout(HangoutInfo hangoutInfo,String userId, MultipartFile file) {
        hangoutInfo.setHangoutImageUrl(RandomStringUtils.randomAlphabetic(10) + file.getOriginalFilename());
        System.out.println(hangoutInfo.getHangoutImageUrl());
        try {
            URL resourceUrl = this.getClass().getResource("/");
            String RESOURCES_DIR = this.getClass().getClassLoader().getResource("static/").getPath();
            //String RESOURCES_DIR = this.getClass().getClassLoader().getResource("static").getPath();
            System.out.println(RESOURCES_DIR);
            Path newFile = Paths.get(RESOURCES_DIR + hangoutInfo.getHangoutImageUrl());

            Files.createDirectories(newFile.getParent());
            Files.write(newFile, file.getBytes());
//
//            System.out.println(str);
//            File saveFile = new File(str);
//            //Path path = Paths.get(str).toRealPath();
//           // System.out.println(path);
//            file.transferTo(saveFile);

        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println("error");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
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
