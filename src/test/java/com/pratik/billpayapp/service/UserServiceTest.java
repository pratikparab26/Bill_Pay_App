package com.pratik.billpayapp.service;

import com.pratik.billpayapp.dto.Users;
import com.pratik.billpayapp.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService testClass = new UserService();

    private Users user1;

    @BeforeEach
    public void setMockOutput() {
        user1 = new Users();
        user1.setEmailID("abc@gmail.com");
        Optional<Users> opUser = Optional.of(user1);
        Optional<Users> noUSer = Optional.empty();

        when(userRepository.findById(Mockito.eq("abc@gmail.com"))).thenReturn(opUser);
        when(userRepository.findById(Mockito.eq("xyb@gmail.com"))).thenReturn(noUSer);
        when(userRepository.save(Mockito.eq(user1))).thenReturn(user1);
    }

    @Test
    public void checkIFUserIsPresent(){
        assertTrue(testClass.isRegistered("abc@gmail.com"));
    }

    @Test
    public void checkIFUserIsNotPresent(){
        assertFalse(testClass.isRegistered("xyb@gmail.com"));
    }

    @Test
    public void getUserDetails(){
        assertTrue(testClass.getUser("abc@gmail.com").getEmailID().equals(user1.getEmailID()));
    }

    @Test
    public void saveUser(){
        testClass.register("abc@gmail.com");
    }
    @Test
    public void getUserDetailsNoTValidUser(){
        Exception exception =  assertThrows(RuntimeException.class,()->testClass.getUser("xyb@gmail.com"));
        assertTrue(exception.getMessage().contains("xyb@gmail.com is not registered"));
    }

}