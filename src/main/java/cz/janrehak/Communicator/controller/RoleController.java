package cz.janrehak.Communicator.controller;


import cz.janrehak.Communicator.model.Role;
import cz.janrehak.Communicator.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping public Set<Role> listRoles() {
		return roleRepository.findAll();
	}
}
