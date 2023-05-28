package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findUserById(Long id);

  List<User> findAll();

  boolean existsUserByNameAndPassword(String name, String password);
  User findUserByName(String name);
}
