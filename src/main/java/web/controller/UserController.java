package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;
import web.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PostService postService;

    @GetMapping(value = "/user")
    public String usersPosts(HttpServletRequest request, Model model, User user) {
        HttpSession session = request.getSession();
        model.addAttribute("user", user);
        model.addAttribute("postListByUser", postService.allUsersPostsById(user));
        return "usersPosts";
    }

}