package com.bs.spring.bank.model.service;

import com.bs.spring.bank.model.dto.Bank;
import java.util.*;

public interface BankService {

    List<Bank> getAllLoans();
    Bank findLoanById(int loanNo);
    int updateLoanAmount(int loanNo, int newAmount);



    // ✅ 특정 유저의 대출 내역 조회 메서드 추가
    List<Bank> getLoansByUserId(String userId);
    int insertLoan(Bank bank);

    int getPlaydayByUserId(String userId);

    Map<String, Object> getDailyRevenue(String userId, int selectedDay);
}
