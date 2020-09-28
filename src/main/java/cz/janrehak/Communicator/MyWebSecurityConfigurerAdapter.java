package cz.janrehak.Communicator;


import cz.janrehak.Communicator.model.Role;
import cz.janrehak.Communicator.repository.UserRepository;
import cz.janrehak.Communicator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired UserService userService;


//        @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            @Transactional(readOnly = true)
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                cz.janrehak.Communicator.model.User user = userRepository.findByName(username)
//                        .orElseThrow(() -> new UsernameNotFoundException(username));
//
//                return User.builder()
//                        .username(user.getName())
//                        .password(user.getPassword())
//                        .authorities(
//                                user.getRoles().stream().map(Role::getName).map(roleName -> new SimpleGrantedAuthority("ROLE_" + roleName)).collect(Collectors.toSet())
//                        )
//                        .build();
//            }
//        };
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    //nahrazuji to UserDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Magdalena")
                .password(passwordEncoder().encode("magda")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().httpBasic()
                .and().csrf().disable();
//        http.authorizeRequests().antMatchers("/").permitAll();

    }
}