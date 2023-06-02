package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.Post;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public User getById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Не удалось найти пользователя по id: " + id + " Попробуйте снова."));
  }

  @Override
  public List<User> findAll() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public User update(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
    System.out.println("Успешно удалён пользователь с id: " + id);
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findUserByEmail(email)
        .orElseThrow(() -> new RuntimeException("Не удалось найти пользователя по email: " + email + " Попробуйте снова."));
  }
  public User findUserByEmail(String email) {
    return userRepository.findUserByEmail(email);
  }

  public User findUserByPosts(Post post) {
    return userRepository.findUserByPosts(post);
  }
}
