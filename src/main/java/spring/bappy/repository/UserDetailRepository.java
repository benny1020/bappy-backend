package spring.bappy.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserDetail;

public interface UserDetailRepository extends MongoRepository<UserDetail,String> {
    public UserDetail findUserDetailByUserDetailId(ObjectId userDetailId);

}
