package web.controller;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Post;
import web.model.User;
import web.service.PostService;
import web.service.UserServiceEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
@RequiredArgsConstructor
public class PagebleController {

    private final UserServiceEntity userService;
    private final PostService postService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<String> findPostByUser(@PathVariable("id") Long id) {
        Pageable pageable = PageRequest.of(0,2, Sort.by("date").ascending());
        return ResponseEntity.ok(postService.findByUserId(id, pageable).toString());
    }

    @GetMapping(value = "/findPostByDate")
    public ResponseEntity<String> findPostByDate(@RequestParam LocalDate date) {
        Pageable pageable = PageRequest.of(0,4, Sort.by("date").ascending());
        Page<Post> result = postService.findByDate(date, pageable);
        System.out.println(result.getNumber());
        System.out.println(result.getTotalElements());
        System.out.println(result.getSize());
        System.out.println(result.getTotalPages());
        return ResponseEntity.ok(result.toString());
    }

    @GetMapping(value = "/findAllPost")
    public ResponseEntity<String> findAllPosts() {
        List<Post> all = postService.findAll();
        for (Post post : all) {
            System.out.println(post);
        }
        return ResponseEntity.ok(all.toString());
    }

    @GetMapping
    public ResponseEntity<String> getAll(
            @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) Integer limit) {
        Pageable pageable = PageRequest.of(offset,limit);
        Page<Post> result = postService.findAllPosts(pageable);
        System.out.println(result.getNumber());
        System.out.println(result.getTotalElements());
        System.out.println(result.getSize());
        System.out.println(result.getTotalPages());
        return ResponseEntity.ok(result.toString());
    }
}
