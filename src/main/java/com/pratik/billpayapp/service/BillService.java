package com.pratik.billpayapp.service;

import com.pratik.billpayapp.dto.Bill;
import com.pratik.billpayapp.dto.Biller;
import com.pratik.billpayapp.repository.BillRepository;
import com.pratik.billpayapp.repository.BillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private BillerRepository billerRepository;

    @Autowired
    private BillRepository billRepository;

    public List<Biller> getPendingBillersOfUser(String userID){
        List<Bill> bills = billRepository.findByUserIDAndIsPaid(userID,false);
        if(!CollectionUtils.isEmpty(bills)){
            List<String> billerIds = bills.stream()
                    .map(Bill::getBillerID)
                    .distinct()
                    .collect(Collectors.toList());

            return billerRepository.findAllByidIn(billerIds);
        } else{
            return new ArrayList<>(0);
        }
    }

    public List<Bill> getPendingBillsOfBiller(String billerID, String userID){
        return billRepository.findByBillerIDAndUserIDAndIsPaid(billerID,userID,false);
    }

    public List<Bill> getAllBillsOfBiller(String billerID, String userID){
        return billRepository.findByBillerIDAndUserID(userID,userID);
    }

    public List<Bill> getAllBillsOfUser(String userID ){
        return billRepository.findByUserID(userID);
    }

    public void markBillAsPaid(String billID){
        billRepository.markBillAsPaid(billID);
    }

}
