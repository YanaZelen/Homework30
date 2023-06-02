package web.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tasks")
public class Task  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Task() {

    }

}
