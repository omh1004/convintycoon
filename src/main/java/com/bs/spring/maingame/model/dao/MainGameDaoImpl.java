package com.bs.spring.maingame.model.dao;

import com.bs.spring.bank.model.dto.Bank;
import com.bs.spring.maingame.model.dto.Game;
import com.bs.spring.maingame.model.dto.Product;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Storage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.maingame.model.dto.Revenue;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class MainGameDaoImpl implements MainGameDao {
    @Override
    @Transactional
    public int newGame(SqlSession session, Game game){

        int result = session.insert("maingame.newGame", game);

        log.info("결과확인"+result);


        return result;
//        return 0;
    }

    @Override
    @Transactional
    public int getNewGameCode(SqlSession session, String userId) {
        return session.selectOne("maingame.getNewGameCode", userId);
    }

    @Override
    @Transactional
    public int newLoan(SqlSession session, String userId, Integer gameNo){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("gameNo", gameNo);
        return session.insert("maingame.newLoan",params);
    }

    @Override
    public List<Product> getAllProductByGameNo(SqlSession session, Integer gameNo){
        return session.selectList("maingame.getAllProductByGameNo",gameNo);
//      return null;
    }

  @Override
  @Transactional
  public int saveEndResult(SqlSession session, Revenue revenue){
     return session.insert("maingame.saveEndResult",revenue);
//    return 0;
  }

  @Override
  @Transactional
  public int updateStorage(SqlSession session, Storage storage) {
     return session.update("maingame.updateStorage",storage);
//    return 0;
  }

    @Override
    public int moneyExpense(SqlSession session, Integer price, Integer gameNo){
        Map<String, Integer> params = new HashMap<>();
        params.put("price", price);
        params.put("gameNo", gameNo);
        return session.update("maingame.moneyExpense",params);
    }

    @Override
    public int moneyChange(SqlSession session, Integer price, Integer gameNo){
        Map<String, Integer> params = new HashMap<>();
        params.put("price", price);
        params.put("gameNo", gameNo);
        return session.update("maingame.moneyChange",params);
    }

    @Override
    public int getMoneyData(SqlSession session, Integer gameNo){
        return session.selectOne("maingame.getMoneyData", gameNo);
    }

    @Override
    @Transactional
    public int getGamePlayDay(SqlSession session, String userId) {
        return session.selectOne("maingame.getGamePlayDay", userId);
    }

    @Override
    public int daysChange(SqlSession session, Integer salesDay, Integer gameNo){
        Map<String, Integer> params = new HashMap<>();
        params.put("salesDay", salesDay);
        params.put("gameNo", gameNo);
        return session.update("maingame.daysChange",params);
    }

    @Override
    public Game getCashAndLoan(SqlSession session, Integer gameNo){
        return session.selectOne("maingame.getCashAndLoan", gameNo);
    }

    @Override
    public List<Revenue> getQuizAndDispose(SqlSession session, Integer gameNo){
        return session.selectList("maingame.getQuizAndDispose", gameNo);
    }
}
