package cz.janrehak.Communicator.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue(generator = "message_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "message_id_seq",
            sequenceName = "message_id_seq",
            allocationSize = 50
    )
    private Long id;

    @Column(name = "text_content", length = 65536)
    private String content;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne
    @JoinTable(name="message_topic",
            joinColumns = @JoinColumn(name="message_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="topic_id", referencedColumnName = "id")
    )
    private Topic topic;


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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
