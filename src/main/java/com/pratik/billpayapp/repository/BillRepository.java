package com.pratik.billpayapp.repository;

import com.pratik.billpayapp.dto.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {

    List<Bill> findByUserID(String  userID);

    List<Bill> findByUserIDAndIsPaid(String userID, boolean isPAid);

    List<Bill> findByBillerIDAndUserIDAndIsPaid(String billerID, String userID,boolean isPAid);

    List<Bill> findByBillerIDAndUserID(String billerID, String userID);

    @Transactional
    @Modifying
    @Query("update Bill  set isPaid = TRUE where id = :billID")
    void markBillAsPaid(@Param("billID")String billID);
}
