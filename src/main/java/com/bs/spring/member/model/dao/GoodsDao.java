package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Ordering;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface GoodsDao {
    List<Ordering> selectAllPrd(SqlSession session);

//    int insertOrdering(SqlSession session ,Goods inputGoods);
}
