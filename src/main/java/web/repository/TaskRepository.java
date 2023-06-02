package web.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import web.model.Task;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> getTaskByUser_Id(Long userId, Pageable pageable);
}
