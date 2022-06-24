package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserPersonality;

public interface UserPersonalityRepository extends MongoRepository<UserPersonality,String> {

}
