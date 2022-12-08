package com.pratik.billpayapp.controller;

import com.pratik.billpayapp.model.UserReg;
import com.pratik.billpayapp.service.UserService;
import com.pratik.billpayapp.service.WalletService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/users")
public class UserController {

    private static Logger log = LogManager.getLogger(UserController.class);

    //user related
    ///registrations/email
    //login/
    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @PostMapping("/")
    public String registerNewUser(@RequestBody @Valid UserReg data){
        log.info(":: REQUEST START :: REGISTRATION");

        if(userService.isRegistered(data.getEmailID())){
            //send error;
            return "User is already registered!!";

        } else{
            userService.register(data.getEmailID());
            if(data.getAmount()!= 0.0){
                walletService.createWallet(data.getEmailID(), data.getAmount());
            }else{
                walletService.createWallet(data.getEmailID());
            }
        }
        log.info(":: REQUEST END :: REGISTRATION");
        return "Registration Complete!!";

    }
}
