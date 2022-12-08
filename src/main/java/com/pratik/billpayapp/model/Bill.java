package com.pratik.billpayapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Bill {


    @Id
    private String id;
    private String billerID;
    private double amount;
    private boolean isPaid;
}
