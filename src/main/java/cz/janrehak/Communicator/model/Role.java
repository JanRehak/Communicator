package cz.janrehak.Communicator.model;

import javax.persistence.*;


@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(generator = "role_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "role_id_seq",
            sequenceName = "role_id_seq",
            allocationSize = 50
    )
    private Long id;

    //TODO define FINAL roles??
//    private final  List<String> roles = new List<>();


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
