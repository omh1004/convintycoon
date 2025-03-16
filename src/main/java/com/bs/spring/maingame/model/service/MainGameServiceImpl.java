package com.bs.spring.maingame.model.service;

import com.bs.spring.member.model.dto.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.bs.spring.maingame.model.dao.MainGameDao;
import com.bs.spring.maingame.model.dto.Revenue;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainGameServiceImpl implements MainGameService{
  private final SqlSession session;
  private final MainGameDao dao;

  @Override
  public int saveEndResult(Revenue revenue){
    return dao.saveEndResult(session, revenue);
  }

  @Override
  public int updateStorage(Goods goods){ return dao.updateStorage(session, goods); }
}
