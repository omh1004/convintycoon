package com.bs.spring.maingame.model.service;

import com.bs.spring.bank.model.dto.Bank;
import com.bs.spring.maingame.model.dto.Game;
import com.bs.spring.maingame.model.dto.Product;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Storage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.bs.spring.maingame.model.dao.MainGameDao;
import com.bs.spring.maingame.model.dto.Revenue;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainGameServiceImpl implements MainGameService{
  private final SqlSession session;
  private final MainGameDao dao;

  @Override
  @Transactional
  public int startNewGame(Game game){
    int result = dao.newGame(session, game);
    int gameCode = dao.getNewGameCode(session, game.getUserId());
    int result2 = dao.newLoan(session, game.getUserId(), gameCode);
    if(result>0 && result2>0){
      return gameCode;
    }else{
      return 0;
    }
  }

  @Override
  public List<Product> getAllProductByGameNo(Integer gameNo){
    List<Product> product = dao.getAllProductByGameNo(session, gameNo);
    return product;
  }

  @Override
  @Transactional
  public int saveRevenueAndUpdateStorage(Revenue revenue, List<Storage> storage){
    int result = dao.saveEndResult(session, revenue);
    int result2 = dao.moneyChange(session, revenue.getDayendcash(),revenue.getPlayNo());
    int result3 = dao.daysChange(session, revenue.getSalesDay(), revenue.getPlayNo());
    storage.forEach(s->{
      dao.updateStorage(session, s);
    });

    return result;
  }

  @Override
  public int moneyExpense(Integer price, Integer gameNo){
    return dao.moneyExpense(session, price, gameNo);
  }

  @Override
  public int getMoneyData(Integer gameNo){
    return dao.getMoneyData(session, gameNo);
  }

  @Override
  @Transactional
  public Map<String,Object> getCashLoanQuiz(Integer gameNo){
    Map<String,Object> data = new HashMap<>();

    // playday, cash, loan
    Game cashAndLoan = dao.getCashAndLoan(session, gameNo);
    // quizYN, disposal
    List<Revenue> revenueList = dao.getQuizAndDispose(session, gameNo);

    data.put("cashloan",cashAndLoan);
    data.put("quizdisposal",revenueList);

    return data;
  }
//  @Override
//  public int saveEndResult(Revenue revenue){
//    return dao.saveEndResult(session, revenue);
//  }
//
//  @Override
//  public int updateStorage(Storage storage){ return dao.updateStorage(session, storage); }


  @Override
  public int getGamePlayDay(String userId) {
    return dao.getGamePlayDay(session, userId);
  }
}
