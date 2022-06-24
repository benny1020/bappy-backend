package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserLanguage;

public interface UserLanguageRepository extends MongoRepository<UserLanguage,String> {

}
