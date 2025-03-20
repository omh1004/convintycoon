package com.bs.spring.bank.model.service;

import com.bs.spring.bank.model.dao.BankDao;
import com.bs.spring.bank.model.dto.Bank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.*;

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

//    @Override
//    public int updateLoanAmount(int loanNo, int newAmount) {
//        return dao.updateLoanAmount(session, loanNo, newAmount);
//    }




    // ✅ 특정 회원의 대출 내역 조회 추가
    @Override
    public List<Bank> getLoansByGameNo(String gameNo) {
        return dao.getLoansByGameNo(session, gameNo);
    }

    @Override
    public int insertLoan(Bank bank) {
//        return dao.insertLoan(session, bank);
        int result = dao.insertLoan(session, bank);  // 대출 정보 저장

        if (result > 0) {
            // 대출이 성공했으면, CASH 업데이트 실행
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("gameNo", bank.getGameNo());
            paramMap.put("loanMoney", bank.getLoanMoney());
            dao.updateGameLoan(session, paramMap);

            System.out.println("✅ 대출 성공! Cash 업데이트 완료");
        } else {
            System.out.println("❌ 대출 실패! Cash 업데이트 실패");
        }
        return result;

    }

    @Override
    public int getPlaydayByGameNo(String gameNo) {
        return dao.getPlaydayByGameNo(session, gameNo);
    }

    @Override
    public Map<String, Object> getDailyRevenue(String gameNo, int selectedDay) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameNo", gameNo);
        paramMap.put("selectedDay", selectedDay);
        return dao.getDailyRevenue(session, paramMap);
    }

    @Override
    public int getGameCash(String gameNo) {
        return dao.getGameCash(session, gameNo);
    }

}
