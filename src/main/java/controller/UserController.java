package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/")
    public ResponseEntity<String> getHomePage() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users.toString());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<String> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id).toString());
    }

    @GetMapping(value = "/user/signUp")
    public String signUp(User user) {
        boolean result = userService.existUser(user.getName(), user.getPassword());
        if (!result) {
            userService.addUser(user);
            return "login";
        }
        System.out.println("Пользователь уже существует");
        return "login";
    }

    @PostMapping(value = "/user")
    public String signIn(HttpServletRequest request , User user, Model model) {
        System.out.println(user);
        boolean result = userService.existUser(user.getName(), user.getPassword());
        if (result) {
            User userEntity = userService.getByName(user.getName());
            request.getSession().setAttribute("user", userEntity);
            model.addAttribute("user", userEntity);
            return "index";
        }
        System.out.println("Не удалось авторизоваться");
        return "login";
    }

    @GetMapping(value = "/user/list")
    public String userInfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login";
        }
        model.addAttribute("userList", userService.findAllUsers());
        return "userInfo";
    }
}