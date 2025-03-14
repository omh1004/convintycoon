package com.bs.spring.maingame.model.service;

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
}
