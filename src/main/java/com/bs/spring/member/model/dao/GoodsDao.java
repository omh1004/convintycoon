package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Goods;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface GoodsDao {
    List<Goods> selectAllPrd(SqlSession session);
}
