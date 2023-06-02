package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.repository.PostRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsService {

    private final PostRepository postRepo;


    public Post save(Post post) {
        return postRepo.save(post);
    }

    public List<Post> findAll() {
        return (List<Post>) postRepo.findAll();
    }

    public Post get(long id) {
        return postRepo.findById(id).get();
    }

    public void delete(long id) {
        postRepo.deleteById(id);
    }

    public List<Post> findByUser(Long userId, Pageable pageable) {
        return postRepo.getPostByUser_Id(userId, pageable);
    }


}
