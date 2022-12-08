package com.pratik.billpayapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Biller {
    @Id
    private String id;
    private String name;
}
