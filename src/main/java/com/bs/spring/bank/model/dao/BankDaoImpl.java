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
    public List<Bank> getLoansByGameNo(SqlSession session, String gameNo) {

        if (gameNo == null || gameNo.trim().isEmpty()) {
            System.out.println("ERROR: gameNo가 NULL이거나 비어 있음.");
            throw new IllegalArgumentException("gameNo가 null이거나 빈 값입니다.");
        }

        System.out.println("📌 MyBatis 실행: getLoansByGameNo, gameNo = " + gameNo);

        return session.selectList("bank.getLoansByGameNo", gameNo);
    }

    @Override
    public int insertLoan(SqlSession session, Bank bank) {
        return session.insert("bank.insertLoan", bank);
    }

    @Override
    public int updateGameLoan(SqlSession session, Map<String, Object> paramMap) {
        return session.update("bank.updateGameLoan", paramMap);
    }


    @Override
    public int getPlaydayByGameNo(SqlSession session, String gameNo) {
        return session.selectOne("bank.getPlaydayByGameNo", gameNo);
    }

    @Override
    public Map<String, Object> getDailyRevenue(SqlSession session, Map<String, Object> paramMap) {
        return session.selectOne("bank.getDailyRevenue", paramMap);
    }

    @Override
    public int getGameCash(SqlSession session, String gameNo) {
        return session.selectOne("bank.getGameCash", gameNo);
    }

}
