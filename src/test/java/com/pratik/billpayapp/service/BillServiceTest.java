package com.pratik.billpayapp.service;

import com.pratik.billpayapp.dto.Bill;
import com.pratik.billpayapp.dto.Biller;
import com.pratik.billpayapp.repository.BillRepository;
import com.pratik.billpayapp.repository.BillerRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BillServiceTest {

    @Mock
    private BillRepository billRepository;

    @Mock
    private BillerRepository billerRepository;

    @InjectMocks
    private BillService testClass = new BillService();

    String emailID="abc@gmail.com";

    @BeforeEach
    void setMockOutput() {
        List<Bill> pendingBillList = new ArrayList<>();
        Bill pb1 = Bill.builder()
                .userID("abc@gmail.com")
                .billerID("b1")
                .amount(20.0)
                .id("1")
                .isPaid(false)
                .build();
        pendingBillList.add(pb1);

        List<Bill> paidBillList = new ArrayList<>();
        Bill b1 = Bill.builder()
                .userID("xyj@gmail.com")
                .billerID("b1")
                .amount(40.0)
                .id("2")
                .isPaid(true)
                .build();
        paidBillList.add(b1);

        List<Biller> billers = new ArrayList<>();
        Biller biller =  new Biller();
        biller.setId("b1");
        biller.setName("Biller1");
        billers.add(biller);
        when(billRepository.findByUserIDAndIsPaid(Mockito.eq("abc@gmail.com"),Mockito.eq(false))).thenReturn(pendingBillList);
        when(billRepository.findByBillerIDAndUserIDAndIsPaid(Mockito.anyString(),Mockito.eq("abc@gmail.com"),Mockito.eq(false))).thenReturn(pendingBillList);
        when(billRepository.findByUserIDAndIsPaid(Mockito.anyString(),Mockito.eq(true))).thenReturn(paidBillList);
        when(billerRepository.findAllByidIn(Mockito.anyList())).thenReturn(billers);
    }


    @Test
    void givenUserID_WhenGetPendingBillersOfUserisCalled_ThenPendingBillisReturned(){
        List<Biller> result = testClass.getPendingBillersOfUser(emailID);
        assertTrue(!CollectionUtils.isEmpty(result));
    }

    @Test
    void givenDiffUserID_WhenGetPendingBillersOfUserisCalled_ThenNoPendingBillisReturned(){
        List<Biller> result = testClass.getPendingBillersOfUser("xyz@gmail.com");
        assertTrue(CollectionUtils.isEmpty(result));
    }

    @Test
    void givenUserID_WhenGetPendingBillsOfBillerisCalled_ThenPendingBillisReturned(){
        List<Bill> result = testClass.getPendingBillsOfBiller("b1","abc@gmail.com");
        assertTrue(!CollectionUtils.isEmpty(result));
    }


}