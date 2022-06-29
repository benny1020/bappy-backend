package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.Hangout.HangoutInfo;

public interface HangoutInfoRepository extends MongoRepository<HangoutInfo, String> {
    public HangoutInfo findHangoutInfoByHangoutInfoId(String hangoutInfoId);
}
