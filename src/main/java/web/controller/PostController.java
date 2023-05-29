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
import java.time.LocalDate;

@Controller
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/post/add/{id}")
    public String addPost(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        User user = postService.userById(id);
        LocalDate date = LocalDate.now();
        model.addAttribute("user", user);
        model.addAttribute("date", date);
        return "addPost";
    }

    @PostMapping(value = "/post/add")
    public String addPost(Post post) {
        postService.save(post);
        return "redirect:/post/list";
    }

    @GetMapping(value = "/post/delete/{id}")
    public String deletePost(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        postService.deleteById(id);
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
    public String editPost(HttpServletRequest request, Post post, Model model) {
        postService.save(post);
        model.addAttribute("postList", postService.findAll());
        return "redirect:/post/list";
    }

}