package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.Report.Report;

public interface ReportRepository extends MongoRepository<Report, String> {

}
