package com.bs.spring.bank.model.service;

import com.bs.spring.bank.model.dao.BankDao;
import com.bs.spring.bank.model.dto.Bank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankDao dao;
    private final SqlSession session;

    @Override
    public List<Bank> getAllLoans() {
        return dao.getAllLoans(session);
    }


    @Override
    public Bank findLoanById(int loanNo) {
        return dao.findLoanById(session, loanNo);
    }

    @Override
    public int updateLoanAmount(int loanNo, int newAmount) {
        return dao.updateLoanAmount(session, loanNo, newAmount);
    }




    // ✅ 특정 회원의 대출 내역 조회 추가
    @Override
    public List<Bank> getLoansByUserId(String userId) {
        return dao.getLoansByUserId(session, userId);
    }

    @Override
    public int insertLoan(Bank bank) {
        return dao.insertLoan(session, bank);
    }
}
