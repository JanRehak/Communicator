package cz.janrehak.Communicator.model;

import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message", length = 65536)
    private String message;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    private LocalDateTime createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
