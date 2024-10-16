package com.Muhammadcoder.SpringSecurity_for_github.Repository;

import com.Muhammadcoder.SpringSecurity_for_github.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
