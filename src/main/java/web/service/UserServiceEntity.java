package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.model.Post;
import web.repository.RoleRepository;
import web.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceEntity implements UserDetailsService, UserService {

    private final UserRepository repo;
    private final RoleRepository rolRepo;
    private UserDetailsService userDetailsService;

    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        if(rolRepo.count() == 0){
            roles.add(rolRepo.findById(1L).get());
            user.setRoles(roles);
        }
        repo.save(user);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return this.userDetailsService.loadUserByUsername(repo.getUserByName(name));

    }

    public User findUserByPosts(Post post) {
        return repo.findUserByPosts(post);
    }
}
