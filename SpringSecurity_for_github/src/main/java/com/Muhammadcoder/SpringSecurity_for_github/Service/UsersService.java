package com.Muhammadcoder.SpringSecurity_for_github.Service;

import com.Muhammadcoder.SpringSecurity_for_github.Entity.Users;
import com.Muhammadcoder.SpringSecurity_for_github.Repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }
}
