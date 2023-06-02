package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;
import web.service.PostService;
import web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final PostService postService;
/*
    @GetMapping(value = "/user")
    public String userInfo(HttpServletRequest request, Model model) {
        model.addAttribute("userList", userService.findAll());
        return "index";
    }

    @GetMapping(value = "/user/add")
    public String addUser(HttpServletRequest request) {
        return "addUser";
    }

    @PostMapping(value = "/user/add")
    public String addUser(HttpServletRequest request, User user, Model model) {
        userService.addUser(user);
        model.addAttribute("userList", userService.findAll());
        return "redirect:/";
    }


    @GetMapping(value = "/user/delete/{id}")
    public String deleteUser(HttpServletRequest request, User user, Model model) {
        userService.deleteUser(user);
        model.addAttribute("userList", userService.findAll());
        return "redirect:/";
    }

    @GetMapping(value = "/user/edit/{id}")
    public String editUser(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "/user/edit")
    public String editUser(HttpServletRequest request, User user, Model model) {
        userService.addUser(user);
        model.addAttribute("userList", userService.findAll());
        return "redirect:/";
    }

 */

    @GetMapping(value = "/user/{id}")
    public String usersPosts(HttpServletRequest request, Model model, @PathVariable("id") Long id) {
        HttpSession session = request.getSession();
        User user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("postListByUser", postService.allUsersPostsById(user));
        return "usersPosts";
    }

}