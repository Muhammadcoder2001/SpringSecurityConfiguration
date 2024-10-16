package com.Muhammadcoder.SpringSecurity_for_github.Service;

import com.Muhammadcoder.SpringSecurity_for_github.Entity.UserPrincipal;
import com.Muhammadcoder.SpringSecurity_for_github.Entity.Users;
import com.Muhammadcoder.SpringSecurity_for_github.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private  UsersRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
