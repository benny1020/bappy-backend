package spring.bappy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.bappy.services.account.User;

import java.util.List;


public interface AccountRepository extends MongoRepository<User, String> {
    User findByUserId(String userId);
}
