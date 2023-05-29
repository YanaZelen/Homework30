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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping(value = "/post/list")
    public String userPosts(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("postList", postService.findAll());
        return "usersPosts";
    }

    @GetMapping(value = "/post/add/{id}")
    public String addPost(HttpServletRequest request) {
        return "addPost";
    }

    @PostMapping(value = "/post/add")
    public String addPost(Post post) {
        postService.save(post);
        return "redirect:/post/list";
    }

    @GetMapping(value = "/post/delete/{id}")
    public String deletePost(HttpServletRequest request, Post post, Model model) {
        postService.delete(post);
        model.addAttribute("postList", postService.findAll());
        return "redirect:/post/list";
    }

    @GetMapping(value = "/post/edit/{id}")
    public String editPost(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping(value = "/post/edit")
    public String editUser(HttpServletRequest request, Post post, Model model) {
        postService.save(post);
        model.addAttribute("postList", postService.findAll());
        return "redirect:/post/list";
    }

}