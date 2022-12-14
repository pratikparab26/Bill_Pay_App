package com.pratik.billpayapp.service;

import com.pratik.billpayapp.dto.Users;
import com.pratik.billpayapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isRegistered(String emailID){
        Optional<Users> user = userRepository.findById(emailID);
        return user.isPresent();
    }

    public void register(String emailID){
        userRepository.save(new Users(emailID));
    }

    public Users getUser(String emailID){
        Optional<Users> user = userRepository.findById(emailID);
        if(user.isPresent()){
            return user.get();
        } else{
            throw new RuntimeException(emailID +" is not registered");
        }
    }
}
