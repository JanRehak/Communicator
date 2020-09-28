package cz.janrehak.Communicator.service.impl;


import cz.janrehak.Communicator.model.User;
import cz.janrehak.Communicator.repository.UserRepository;
import cz.janrehak.Communicator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository;


    @Override
    public User createUser(User user) {
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
