package com.xworkz.userlogin.service;

import com.xworkz.userlogin.dto.UserDTO;
import com.xworkz.userlogin.entity.UserEntity;
import com.xworkz.userlogin.repository.UserRepository;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.jws.soap.SOAPBinding;

public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder cryptPasswordEncoder;

    @Override
    public boolean save(UserDTO dto){
        UserEntity entity= new UserEntity();
        BeanUtils.copyProperties(dto,entity);
        entity.setPassword(cryptPasswordEncoder.encode(dto.getPassword()));
        entity.setPresent(true);
        return userRepository.save(entity);
    }

    @Override
    public UserDTO acceptLogin(String email, String password) {

        UserEntity entity = userRepository.acceptLogin(email);

        if (entity==null){
            return null;
        }
        if (!cryptPasswordEncoder.matches(password, entity.getPassword())){
            return null;
        }
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(entity,dto);
        System.out.println("Service fetch by login: "+entity);
        return dto;
    }

    @Override
    public String getByEmail(String mail) {
        System.out.println("GetMail in service");
        return userRepository.getByEmail(mail);
    }

    @Override
    public Long getByMobile(Long num) {
        return 0L;
    }


}
