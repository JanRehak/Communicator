package cz.janrehak.Communicator.repository;


import cz.janrehak.Communicator.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {

    @Override
    Set<Role> findAll();

    Set<Role> findByName(String name);



}
