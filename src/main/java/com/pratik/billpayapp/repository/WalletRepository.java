package com.pratik.billpayapp.repository;

import com.pratik.billpayapp.dto.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,String> {
}
