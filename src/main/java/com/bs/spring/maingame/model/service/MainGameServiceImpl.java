package com.bs.spring.maingame.model.service;

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

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainGameServiceImpl implements MainGameService{
  private final SqlSession session;
  private final MainGameDao dao;

  @Override
  public int newGame(Game game){
    int result = dao.newGame(session, game);
    return result;
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
    storage.forEach(s->{
      dao.updateStorage(session, s);
    });

    return result;
  }
//  @Override
//  public int saveEndResult(Revenue revenue){
//    return dao.saveEndResult(session, revenue);
//  }
//
//  @Override
//  public int updateStorage(Storage storage){ return dao.updateStorage(session, storage); }
}
