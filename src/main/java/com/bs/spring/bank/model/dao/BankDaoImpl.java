package com.bs.spring.bank.model.dao;

import com.bs.spring.bank.model.dto.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;

import java.util.*;


@Repository
public class BankDaoImpl implements BankDao {

    @Override
    public List<Bank> getAllLoans(SqlSession session) {
        return session.selectList("bank.getAllLoans");
    }

    @Override
    public Bank findLoanById(SqlSession session, int loanNo) {
        return session.selectOne("bank.findLoanById", loanNo);
    }

//    @Override
//    public int updateLoanAmount(SqlSession session, int loanNo, int newAmount) {
//        return session.update("bank.updateLoanAmount",
//                new Bank(loanNo, newAmount, null, 0, null));
//    }


    // ✅ 특정 회원의 대출 내역 조회 추가
    @Override
    public List<Bank> getLoansByUserId(SqlSession session, String userId) {

        if (userId == null || userId.trim().isEmpty()) {
            System.out.println("ERROR: userId가 NULL이거나 비어 있음.");
            throw new IllegalArgumentException("userId가 null이거나 빈 값입니다.");
        }

        System.out.println("📌 MyBatis 실행: getLoansByUserId, userId = " + userId);

        return session.selectList("bank.getLoansByUserId", userId);
    }

    @Override
    public int insertLoan(SqlSession session, Bank bank) {
        return session.insert("bank.insertLoan", bank);
    }

    @Override
    public int getPlaydayByUserId(SqlSession session, String userId) {
        return session.selectOne("bank.getPlaydayByUserId", userId);
    }

    @Override
    public Map<String, Object> getDailyRevenue(SqlSession session, Map<String, Object> paramMap) {
        return session.selectOne("bank.getDailyRevenue", paramMap);
    }


}
