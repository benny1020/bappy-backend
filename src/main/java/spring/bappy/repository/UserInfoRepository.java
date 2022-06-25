package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

    public UserInfo findUserInfoByUserId(String userId);
}
