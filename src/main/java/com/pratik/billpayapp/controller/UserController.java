package com.pratik.billpayapp.controller;

import com.pratik.billpayapp.model.RechargeWallet;
import com.pratik.billpayapp.model.UserReg;
import com.pratik.billpayapp.service.UserService;
import com.pratik.billpayapp.service.WalletService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private static Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @PostMapping("/users")
    public String registerNewUser( @Valid @RequestBody UserReg data){
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

    @GetMapping("users/{emailID}")
    public String getUser(@PathVariable String emailID){
        return userService.getUser(emailID).getEmailID();
    }


    @PutMapping("/users/addMoney")
    public String addMoneyToWallet(@RequestBody RechargeWallet rechargeWallet){
        double newBalance = walletService.addMoney(rechargeWallet.getUserID(), rechargeWallet.getRechargeAmount());
        return "Recharge successful!! new Balance is: "+ newBalance;
    }


    @GetMapping("/users/{userID}/balances")
    public String addMoneyToWallet(@PathVariable String userID){
        double newBalance = walletService.availableAmount(userID);
        return "Your Current Balance is: "+ newBalance;
    }

}
