package cz.janrehak.Communicator.model;

import javax.persistence.*;

@Entity(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(generator = "topic_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "topic_id_seq",
            sequenceName = "topic_id_seq",
            allocationSize = 50
    )
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
