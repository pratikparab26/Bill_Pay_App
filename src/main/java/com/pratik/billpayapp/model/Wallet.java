package com.pratik.billpayapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Wallet {
    @Id
    private String walletID;
    private String userID;
    private double amount;
}
