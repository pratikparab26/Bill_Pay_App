package com.pratik.billpayapp.service;

import com.pratik.billpayapp.dto.Wallet;
import com.pratik.billpayapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void createWallet(String userID){
        walletRepository.save(Wallet.builder().userID(userID).build());
    }

    public void createWallet(String userID,double amount){
        walletRepository.save(Wallet.builder().userID(userID).amount(amount).build());
    }

    public double addMoney(String userID,double topup){
        double currentMoney ;
        Optional<Wallet> wallet = walletRepository.findById(userID);
        if(wallet.isPresent()){
            currentMoney = wallet.get().getAmount();
            wallet.get().setAmount(currentMoney+topup);
            walletRepository.save(wallet.get());
            return currentMoney+topup;
        } else {
            throw new RuntimeException("Wallet Not Present");
        }
    }

    public double availableAmount(String userID){
        Optional<Wallet> wallet = walletRepository.findById(userID);
        if(wallet.isPresent()){
            return wallet.get().getAmount();
        }else{
            throw new RuntimeException("Wallet Not Present");
        }

    }

    public double useWallet(String fromUserID,String toUserID,double amountToBeDebited){
        Optional<Wallet> fromWallet = walletRepository.findById(fromUserID);
        double newUSerBalance =0.0;
        if(fromWallet.isPresent()){
            if( amountToBeDebited>fromWallet.get().getAmount()){
                throw new RuntimeException("Insufficient balance, Kindly recharge youe wallet!!");
            }else{
                newUSerBalance = fromWallet.get().getAmount()-amountToBeDebited;
                fromWallet.get().setAmount(newUSerBalance);
                walletRepository.save(fromWallet.get());
            }
        }else{
            throw new RuntimeException("Wallet Not Present");
        }

        Optional<Wallet> toWallet = walletRepository.findById(toUserID);

        if(toWallet.isPresent()) {
            double newBalance;
            newBalance = toWallet.get().getAmount() + amountToBeDebited;
            toWallet.get().setAmount(newBalance);
            walletRepository.save(toWallet.get());
        }else{
            //reverting debited Amount
            newUSerBalance = fromWallet.get().getAmount()+amountToBeDebited;
            fromWallet.get().setAmount(newUSerBalance);
            walletRepository.save(fromWallet.get());
            throw new RuntimeException("Wallet Not Present");
        }

        return newUSerBalance;
    }
}
