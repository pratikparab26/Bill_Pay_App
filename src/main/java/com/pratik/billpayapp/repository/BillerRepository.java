package com.pratik.billpayapp.repository;

import com.pratik.billpayapp.dto.Biller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillerRepository extends JpaRepository<Biller,String> {
    List<Biller> findAllByidIn(List<String> id);
}
