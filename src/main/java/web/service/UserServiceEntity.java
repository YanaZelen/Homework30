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

  public void addUser(User user) {
    repo.save(user);
  }

  public void deleteUser(User user) {
    repo.delete(user);
  }

  public User getById(Long id) {
    return repo.findById(id).get();
  }

 public User findUserByPosts(Post post) {
   return repo.findUserByPosts(post);
 }

}
