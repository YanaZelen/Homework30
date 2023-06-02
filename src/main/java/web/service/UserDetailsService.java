package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Task;
import web.repository.TaskRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsService {

    private final TaskRepository taskRepo;


    public Task save(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> findAll() {
        return (List<Task>) taskRepo.findAll();
    }

    public Task get(long id) {
        return taskRepo.findById(id).get();
    }

    public void delete(long id) {
        taskRepo.deleteById(id);
    }

    public List<Task> findByUser(Long userId, Pageable pageable) {
        return taskRepo.getTaskByUser_Id(userId, pageable);
    }


}
