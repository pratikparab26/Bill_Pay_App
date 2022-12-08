package com.pratik.billpayapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayBill {
    private String userID;
    private String billerID;
    private String billID;
    private double amount;
}
