package com.pratik.billpayapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request<T> {
    private Head head;
    private T body;
}
