package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Post;
import web.model.User;
import web.service.PostService;
import web.service.UserServiceEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserServiceEntity userService;

    @GetMapping(value = "/post/add/{id}")
    public String addPost(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        return "addPost";
    }

    @PostMapping(value = "/post/add/{id}")
    public String addPost(Post post, @PathVariable("id") Long id) {
        User user = postService.userById(id);
        post.setUser(user);
        post.setDate(LocalDate.now());
        postService.save(post);
        return "redirect:/user/posts/{id}";
    }

    @GetMapping(value = "/post/delete/{id}")
    public String deletePost(HttpServletRequest request, Post post, Model model) {
        postService.deletePost(post);
        User user = userService.findUserByPosts(post);
        model.addAttribute("postListByUser", postService.allUsersPostsById(user));
        return "redirect:/user/posts/{id}";
    }

    @GetMapping(value = "/post/edit/{id}")
    public String editPost(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping(value = "/post/edit/{id}")
    public String editPost(HttpServletRequest request, Post post, Model model) {
        postService.save(post);
        model.addAttribute("postList", postService.findAll());
        return "redirect:/user/posts/{id}";
    }

}