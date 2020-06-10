package com.survey.app.service;


import com.survey.app.model.User;
import com.survey.app.repoository.UserRepositoy;
import com.survey.app.securityconf.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    UserRepositoy userRepositoy;

    public User addUser(User user) {
        log.info("save user in db");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(user.getRole().toUpperCase());
        return userRepositoy.save(user);
    }

    public List<User> getUsers() {
        return userRepositoy.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepositoy.findByUserName(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        log.info("userPrincipal details "+ userPrincipal.getUsername()+" "+ userPrincipal.getPassword());
        return  userPrincipal;
    }
}
