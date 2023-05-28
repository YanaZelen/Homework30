package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
  private final UserRepository repo;

  public List<User> findAllUsers() {
    return repo.findAll();
  }

  public User findUserById(Long id) {
    return repo.findUserById(id);
  }

  public void addUser(User user) {
    repo.save(user);
  }

  public void deleteUser(User user) {
    repo.save(user);
  }

  public boolean existUser(String name, String password) {
    return repo.existsUserByNameAndPassword(name, password);
  }

  public User getByName(String name) {
    return repo.findUserByName(name);
  }


}
