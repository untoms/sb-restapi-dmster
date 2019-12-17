package com.example.springbootrest.config.security;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.repositories.UserReporisotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserReporisotry userReporisotry;

    @Autowired
    public CustomUserDetailsService(UserReporisotry userReporisotry) {
        this.userReporisotry = userReporisotry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userReporisotry.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("invalid username or password");
        }

        return new CustomUserDetails(user);
    }
}
