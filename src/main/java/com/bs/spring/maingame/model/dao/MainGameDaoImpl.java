package com.bs.spring.maingame.model.dao;

import com.bs.spring.member.model.dto.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.maingame.model.dto.Revenue;

@Repository
public class MainGameDaoImpl implements MainGameDao {
  @Override
  public int saveEndResult(SqlSession session, Revenue revenue){
    // return session.insert("maingame.saveEndResult",revenue);
    return 0;
  }

  @Override
  public int updateStorage(SqlSession session, Goods goods) {
    // return session.update("maingame.updateStorage",goods);
    return 0;
  }
}
