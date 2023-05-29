package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.model.User;
import web.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

  private final PostRepository repo;

  public List<Post> findAll() {
    return repo.findAll();
  }

  public void save(Post post) {
    repo.save(post);
  }

  public void delete(Post post) {
    repo.delete(post);
  }

  public List<Post> allUsersPostsById(User user) {
    List<Post> all = repo.findAllByUser(user);
    return all;
  }

  public Post getById(Long id) {
    return repo.findPostById(id);
  }
}
