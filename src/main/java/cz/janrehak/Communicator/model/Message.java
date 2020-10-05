package cz.janrehak.Communicator.model;

import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text_content", length = 65536)
    private String content;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToMany
    private Set<Topic> topic;


    private LocalDateTime createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void getContent(String content) {
        this.content = content;
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

    public Set<Topic> getTopic() {
        return topic;
    }

    public void setTopic(Set<Topic> topic) {
        this.topic = topic;
    }
}
