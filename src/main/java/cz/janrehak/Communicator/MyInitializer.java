package cz.janrehak.Communicator;


import cz.janrehak.Communicator.model.Message;
import cz.janrehak.Communicator.model.Role;
import cz.janrehak.Communicator.model.User;
import cz.janrehak.Communicator.repository.RoleRepository;
import cz.janrehak.Communicator.service.MessageService;
import cz.janrehak.Communicator.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

@Component
@ComponentScan(basePackages = {"cz.janrehak.Communicator.service"})
public class MyInitializer implements InitializingBean {

    static final Random randomNumberGenerator = new Random();

//    @Autowired MessageService messageService;
    @Autowired UserService userService;
    @Autowired RoleRepository roleRepository;
//    @Autowired PasswordEncoder passwordEncoder;

    //I get the logger that help me with the message while the app is loading
    private static final Logger log = LoggerFactory.getLogger(MyInitializer.class);



//    what is done before Tomcat server is on
    @Override
    public void afterPropertiesSet() throws Exception {

        //Creation of roles
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role userRole = new Role();
        userRole.setName("USER");

        //Save roles into database
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        //TODO autoCheck ADMIN
//        if (!userService.verifyUser("administrator")) {
//            userService.createUser(new User("administrator", "admin", roleRepository.findByName("ADMIN")));
//        }


        //Creation of our admin - Magdalena
        //TODO vytvorit funkci pro check zda li je admin pritomen. zamezi vice cetnym admin stejnym uctum pri opakovanem spousteni
        userService.createUser(new User("Magdalena", "Nova", "kozenka", roleRepository.findByName("ADMIN"),
                "magda"));
//        userService.createUser(new User("Sany", "Bourak", "matros", roleRepository.findAll(), "sany"));


//        for (int i = 0; i<randomNumberGenerator.nextInt(20); i++) {
//            log.info("MATRIX IS LOADING");
//        }

        // fetch all users
        log.info("Users found with getAllUsers():");
        log.info("-------------------------------");
        userService.getAllUsers().stream().map(User::getName).forEach(log::info);




    }
}
