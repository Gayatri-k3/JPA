package com.xworkz.userlogin.service;

import com.xworkz.userlogin.dto.UserDTO;

public interface UserService {
    boolean save(UserDTO dto);

    UserDTO acceptLogin(String email, String password);

    String getByEmail(String mail);

    Long getByMobile(Long num);
}
