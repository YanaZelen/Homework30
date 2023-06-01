package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
  void save(User user);

  List<User> listAll();

  User get(long id);

  void delete(long id);

}
