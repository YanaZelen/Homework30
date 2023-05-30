package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceEntity {
  private final UserRepository repo;

  public List<User> findAll() {
    List<User> all = repo.findAll();
    return all;
  }

  public User findUserById(Long id) {
    return repo.findUserById(id);
  }

  public void addUser(User user) {
    repo.save(user);
  }

  public void deleteUser(User user) {
    repo.delete(user);
  }

  public void deleteUserById(Long id) {
    repo.deleteById(id);
  }

  public boolean existUser(String name, String password) {
    return repo.existsUserByNameAndPassword(name, password);
  }

  public User getByName(String name) {
    return repo.findUserByName(name);
  }

  public User getById(Long id) {
    return repo.findById(id).get();
  }

  public boolean existsUserById(Long id) {
    return repo.existsUserById(id);
  }

 public User findUserByPosts(Post post) {
   return repo.findUserByPosts(post);
 }

}
