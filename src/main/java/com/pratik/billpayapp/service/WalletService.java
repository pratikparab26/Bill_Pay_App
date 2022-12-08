package com.pratik.billpayapp.service;

import com.pratik.billpayapp.model.Wallet;
import com.pratik.billpayapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void createWallet(String userID){
        walletRepository.save(new Wallet("w3",userID,0.0));
    }

    public void createWallet(String userID,double amount){
        walletRepository.save(new Wallet("w3",userID,amount));
    }

    public void addMoney(double topup){

    }

    public double availableAmount(){
        return 0.0;
    }

    public boolean useWallet(double amount){
        return true;
    }
}
