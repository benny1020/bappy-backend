package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.service.account.User;


public interface AccountRepository extends MongoRepository<User, String> {
    User findByUserId(String userId);
}
