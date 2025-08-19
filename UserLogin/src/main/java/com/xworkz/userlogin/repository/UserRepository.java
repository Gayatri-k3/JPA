package com.xworkz.userlogin.repository;

import com.xworkz.userlogin.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

public interface UserRepository {
    boolean save(UserEntity entity);
    UserEntity acceptLogin(String email);

    String getByEmail(String mail);

    Long getByNumber
}
