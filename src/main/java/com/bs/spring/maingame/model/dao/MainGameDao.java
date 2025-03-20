package com.bs.spring.maingame.model.dao;

import com.bs.spring.bank.model.dto.Bank;
import com.bs.spring.maingame.model.dto.Game;
import com.bs.spring.maingame.model.dto.Product;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Storage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.bs.spring.maingame.model.dto.Revenue;

import java.util.List;
import java.util.Map;

public interface MainGameDao {
  int saveEndResult(SqlSession session, Revenue revenue);
  int updateStorage(SqlSession session, Storage storage);
  List<Product> getAllProductByGameNo(SqlSession session, Integer gameNo);
  int newGame(SqlSession session, Game game);
  int newLoan(SqlSession session, @Param("userId") String userId, @Param("gameNo") Integer gameNo);
  int getNewGameCode(SqlSession session, String userId);
  int moneyExpense(SqlSession session, Integer price, Integer gameNo);
  int moneyChange(SqlSession session, Integer price, Integer gameNo);
  int getMoneyData(SqlSession session, Integer gameNo);
  int getGamePlayDay(SqlSession session, String userId);
  int daysChange(SqlSession session, Integer salesDay, Integer gameNo);
  Game getCashAndLoan(SqlSession session, Integer gameNo);
  List<Revenue> getQuizAndDispose(SqlSession session, Integer gameNo);
}
