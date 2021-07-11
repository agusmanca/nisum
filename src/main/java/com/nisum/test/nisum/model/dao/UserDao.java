package com.nisum.test.nisum.model.dao;

import com.nisum.test.nisum.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserDao extends JpaRepository<User, UUID> {
    User findUserByEmail(String email);
    User findUserByName(String name);
}
