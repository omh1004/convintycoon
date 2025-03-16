package com.bs.spring.bank.model.dao;

import com.bs.spring.bank.model.dto.Bank;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface BankDao {


    List<Bank> getAllLoans(SqlSession session);
    Bank findLoanById(SqlSession session, int loanNo);
    int updateLoanAmount(SqlSession session, int loanNo, int newAmount);


    // ✅ 특정 회원의 대출 내역 조회 추가
    List<Bank> getLoansByUserId(SqlSession session, String userId);

    int insertLoan(SqlSession session, Bank bank);

}
