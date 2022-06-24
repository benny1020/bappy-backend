package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserIntersts;

public interface UserInterestsRepository  extends MongoRepository<UserIntersts,String> {

}
