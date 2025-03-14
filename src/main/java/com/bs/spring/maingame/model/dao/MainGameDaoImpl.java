package com.bs.spring.maingame.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.maingame.model.dto.Revenue;

@Repository
public class MainGameDaoImpl implements MainGameDao {
  @Override
  public int saveEndResult(SqlSession session, Revenue revenue){
    // return session.insert("maingame.saveEndResult",adjustment);
    return 0;
  }
}
