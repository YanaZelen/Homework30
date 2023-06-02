package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login.html";
    }

    @GetMapping(value = "/user")
    public String getUserPage() {
        return "user";
    }
    @GetMapping("/admin")
    public ModelAndView allUsers(){
        List<User> users = userService.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        User user = userService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/admin/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.save(user);
        return modelAndView;
    }

    @GetMapping("/admin/add")
    public ModelAndView addPage(){
        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/admin/add")
    public  ModelAndView addCar(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.save(user);
        return modelAndView;
    }

    @GetMapping("/admin/delete/{id}")
    public ModelAndView deleteCar(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.delete(id);
        return modelAndView;
    }
}
