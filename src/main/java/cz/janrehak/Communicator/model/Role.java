package cz.janrehak.Communicator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //napsat list roli final
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
