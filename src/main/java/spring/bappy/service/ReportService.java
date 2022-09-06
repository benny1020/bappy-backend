package spring.bappy.service;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.bappy.domain.Report.Report;
import spring.bappy.repository.ReportRepository;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public boolean createReport(Report report, MultipartFile file) {
        report.setReportImageUrl(RandomStringUtils.randomAlphabetic(10) + file.getOriginalFilename());
        try {
            File saveFile = new File(System.getProperty("user.dir")+"/src/main/resources/static/ReportImage/" + report.getReportImageUrl());
            file.transferTo(saveFile);

        } catch(IOException e) {
            System.out.println("cant make report becauseof image");
            System.out.println(e);
            return false;
        }

        reportRepository.save(report);
        return true;

    }

}
