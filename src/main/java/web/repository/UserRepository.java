package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName (String name);

//    String getName(String name);
    String getUserByName(String name);
}
