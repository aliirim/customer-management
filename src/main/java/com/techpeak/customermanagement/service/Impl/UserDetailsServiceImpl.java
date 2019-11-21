package com.techpeak.customermanagement.service.Impl;

import com.techpeak.customermanagement.entity.Users;
import com.techpeak.customermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByName(username);

        if (users == null)
            throw new UsernameNotFoundException(username);

        return new User(users.getName(), users.getPassword(),
                true,
                true, true,
                true, new ArrayList<>());
    }
}
