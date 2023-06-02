package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.model.Role;
import web.service.UserServiceEntity;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdmimController {

    private final UserServiceEntity userService;
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
        modelAndView.setViewName("editUser");
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
    public ModelAndView addUser(){
        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/admin/add")
    public  ModelAndView addUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.save(user);
        return modelAndView;
    }

    @GetMapping("/admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.delete(id);
        return modelAndView;
    }
}
