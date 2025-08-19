package com.xworkz.userlogin.repository;

import com.xworkz.userlogin.entity.UserEntity;

public class UserRepositoryImplementation implements UserRepository{
    @Override
    public boolean save(UserEntity entity) {
        return false;
    }

    @Override
    public UserEntity acceptLogin(String email) {
        return null;
    }

    @Override
    public String getByEmail(String mail) {
        return "";
    }
}
