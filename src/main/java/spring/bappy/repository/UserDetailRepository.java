package spring.bappy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserDetail;

public interface UserDetailRepository extends MongoRepository<UserDetail,String> {

}
