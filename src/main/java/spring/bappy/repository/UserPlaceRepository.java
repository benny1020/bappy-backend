package spring.bappy.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.bappy.domain.User.UserPersonality;
import spring.bappy.domain.User.UserPlace;

public interface UserPlaceRepository extends MongoRepository<UserPlace,String> {
    public UserPlace findUserPlaceByUserPlaceId(ObjectId userPlaceId);
}
