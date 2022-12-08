package com.pratik.billpayapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UserReg {

    @Email
    private String emailID;
    private double amount;

}
