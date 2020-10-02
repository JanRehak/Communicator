package cz.janrehak.Communicator.service.impl;


import cz.janrehak.Communicator.exception.DatabaseException;
import cz.janrehak.Communicator.model.User;
import cz.janrehak.Communicator.repository.RoleRepository;
import cz.janrehak.Communicator.repository.UserRepository;
import cz.janrehak.Communicator.service.UserService;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRoles().isEmpty()) {
            user.setRoles(roleRepository.findByName("USER"));
        }

        return userRepository.save(user);
    }


        @Override
    public Optional<User> getUser(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
