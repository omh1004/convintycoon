package com.bs.spring.maingame.model.dao;

import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Storage;
import org.apache.ibatis.session.SqlSession;

import com.bs.spring.maingame.model.dto.Revenue;

public interface MainGameDao {
  int saveEndResult(SqlSession session, Revenue revenue);
  int updateStorage(SqlSession session, Storage storage);
}
