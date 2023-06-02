package web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Post;
import web.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findUserById(Long id);
  void deleteById(Long id);
  List<User> findAll();
  boolean existsUserByNameAndPassword(String name, String password);
  boolean existsUserById(Long id);
  User findUserByName(String name);
  User findUserByPosts(Post post);
  User findUserByEmail(String email);
}
