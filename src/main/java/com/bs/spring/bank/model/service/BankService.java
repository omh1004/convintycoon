package com.bs.spring.bank.model.service;

import com.bs.spring.bank.model.dto.Bank;
import java.util.*;

public interface BankService {

    List<Bank> getAllLoans();
    Bank findLoanById(int loanNo);
//    int updateLoanAmount(int loanNo, int newAmount);



    // ✅ 특정 유저의 대출 내역 조회 메서드 추가
    List<Bank> getLoansByGameNo(String gameNo);
    int insertLoan(Bank bank);

    int getPlaydayByGameNo(String gameNo);

    Map<String, Object> getDailyRevenue(String gameNo, int selectedDay);

    int getGameCash(String gameNo);
}
