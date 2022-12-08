package com.pratik.billpayapp.service;

import com.pratik.billpayapp.model.Bill;
import com.pratik.billpayapp.repository.BillRepository;
import com.pratik.billpayapp.repository.BillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillerService {

    @Autowired
    private BillerRepository billerRepository;

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getPendingBillersOfUser(String userID){
        return new ArrayList<>();
    }

    public List<Bill> getPendingBillsOfBiller(String billerID, String userID){
        return new ArrayList<>();
    }

    public List<Bill> getAllBillsOfBiller(String billerID, String userID){
        return null;
    }

    public List<Bill> getAllBillsOfUser(String userID ){
        return null;
    }
}
