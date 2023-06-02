package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.Task;
import web.service.UserDetailsService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final UserDetailsService userDetailsService;

    @GetMapping(value = "/task")
    public String getUserPage() {
        return "task";
    }
    @GetMapping("/tasks")
    public ModelAndView allTasks(){
        List<Task> tasks = userDetailsService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("tasks",tasks);
        return modelAndView;
    }
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<String> findTaskByUser(@PathVariable Long userId) {
        Pageable pageable = PageRequest.of(0,5, Sort.by("name").ascending());
        return ResponseEntity.ok(userDetailsService.findByUser(userId,pageable).toString());
    }

    @GetMapping("/user/{id}/task/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        Task task = userDetailsService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTaskPage");
        modelAndView.addObject("task", task);
        return modelAndView;
    }

    @PostMapping("/user/{id}/task/edit")
    public ModelAndView editUser(@ModelAttribute("task") Task task){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/{id}/");
        userDetailsService.save(task);
        return modelAndView;
    }

    @GetMapping("/user/{id}/task/add")
    public ModelAndView addPage(){
        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.setViewName("addTaskPage");
        modelAndView.addObject("task",new Task());
        return modelAndView;
    }

    @PostMapping("/user/{id}/task/add")
    public  ModelAndView addTask(@ModelAttribute("task") Task task){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/{id}/");
        userDetailsService.save(task);
        return modelAndView;
    }

    @GetMapping("/user/{id}/task/delete/{id}")
    public ModelAndView deleteCar(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/{id}/");
        userDetailsService.delete(id);
        return modelAndView;
    }
}
