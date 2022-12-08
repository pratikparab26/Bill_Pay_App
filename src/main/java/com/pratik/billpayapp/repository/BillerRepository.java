package com.pratik.billpayapp.repository;

import com.pratik.billpayapp.model.Biller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillerRepository extends JpaRepository<Biller,String> {
}
