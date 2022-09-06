package spring.bappy.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.bappy.controllers.response.Message;
import spring.bappy.controllers.response.StatusEnum;
import spring.bappy.domain.Report.Report;
import spring.bappy.service.ReportService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) { this.reportService = reportService; }

    @PostMapping("")
    public ResponseEntity createReport(Report report, HttpServletRequest request, @RequestPart MultipartFile file) {
        String userId = (String)request.getAttribute("userId");
        report.setReportUserId(userId);
        reportService.createReport(report, file);
        Message message = new Message();
        message.setMessage("create report success");
        message.setData(true);
        message.setStatus(StatusEnum.OK);

        return new ResponseEntity(message, HttpStatus.OK);



    }
}
