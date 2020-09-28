package cz.janrehak.Communicator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name =  "streetName")
    private String streetName;

    public User(String streetName) {
        this.streetName = streetName;
    }

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User() {
    }

    public User(String name, String lastName, String streetName, Set<Role> roles, String password) {
        this.name = name;
        this.lastName = lastName;
        this.streetName = streetName;
        this.roles = roles;
        this.password = password;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
