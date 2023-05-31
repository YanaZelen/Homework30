package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.model.User;
import web.repository.PostRepository;
import web.repository.UserRepository;

import java.time.LocalDate;
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

  public Page<Post> findByDate(LocalDate date, Pageable pageable) {
    return repo.findByDate(date, pageable);
  }

  public Page<Post> findAllPosts(Pageable pageable) {
    return repo.findAll(pageable);
  }

  public Page<Post> findByUserId(Long id, Pageable pageable) {
    return repo.findByUserId(id, pageable);
  }
}
