package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.model.User;
import web.repository.PostRepository;
import web.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

  private final PostRepository repo;
  private final UserRepository userRepo;

  public List<Post> findAll() {
    return repo.findAll();
  }

  public void save(Post post) {
    repo.save(post);
  }

  public void deleteById(Long id) {
    repo.deleteById(id);
  }

  public void deletePost(Post post) {
    repo.delete(post);
  }

  public List<Post> allUsersPostsById(User user) {
    List<Post> all = repo.findAllByUser(user);
    return all;
  }

  public Post getById(Long id) {
    return repo.findPostById(id);
  }

  public User userById(Long id) {
    return userRepo.findUserById(id);
  }

}
