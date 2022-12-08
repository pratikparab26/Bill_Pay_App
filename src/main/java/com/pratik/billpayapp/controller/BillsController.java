package com.pratik.billpayapp.controller;

import com.pratik.billpayapp.dto.Bill;
import com.pratik.billpayapp.dto.Biller;
import com.pratik.billpayapp.model.PayBill;
import com.pratik.billpayapp.service.BillService;
import com.pratik.billpayapp.service.UserService;
import com.pratik.billpayapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillsController {

    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    @Autowired
    private WalletService walletService;

    @GetMapping("/users/{userID}/pending/billers")
    public List<Biller> getPendingBillersForUser(@PathVariable String userID){
        return billService.getPendingBillersOfUser(userID);
    }

    @GetMapping("/users/{userID}/Billers/{billerID}")
    public List<Bill> getPendingBillsForUserAndBiller(@PathVariable String userID, @PathVariable String billerID){
        return billService.getPendingBillsOfBiller(billerID,userID);
    }

    @PostMapping("/users/paybills")
    public String payBill(@RequestBody PayBill payBill){
        try {
            double newBalance = walletService.useWallet(payBill.getUserID(), payBill.getBillerID(), payBill.getAmount());
            //updated bill as paid.
            billService.markBillAsPaid(payBill.getBillID());
            return "Bill Paid Successfully!! Your new Balance is: "+newBalance;
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }


}
