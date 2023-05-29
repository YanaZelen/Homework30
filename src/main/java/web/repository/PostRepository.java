package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.model.Post;
import web.model.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findAll();

  @Query("SELECT DISTINCT a FROM Post a JOIN FETCH a.user")
  List<Post> findAllByUser(User user);

  Post findPostById(Long id);

  void deleteById(Long id);
}
