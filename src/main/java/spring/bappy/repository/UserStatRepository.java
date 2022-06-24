package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserStat;

public interface UserStatRepository extends MongoRepository<UserStat,String> {

}
