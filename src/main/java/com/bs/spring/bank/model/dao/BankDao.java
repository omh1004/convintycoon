package com.bs.spring.bank.model.dao;

import com.bs.spring.bank.model.dto.Bank;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public interface BankDao {


    List<Bank> getAllLoans(SqlSession session);
    Bank findLoanById(SqlSession session, int loanNo);
//    int updateLoanAmount(SqlSession session, int loanNo, int newAmount);


    // ✅ 특정 회원의 대출 내역 조회 추가
    List<Bank> getLoansByGameNo(SqlSession session, String gameNo);


    int insertLoan(SqlSession session, Bank bank);
    int updateGameLoan(SqlSession session, Map<String, Object> paramMap);

    int getPlaydayByGameNo(SqlSession session, String gameNo);

    Map<String, Object> getDailyRevenue(SqlSession session, Map<String, Object> paramMap);

    int getGameCash(SqlSession session, String gameNo);
}
