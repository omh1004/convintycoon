package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Storage;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface GoodsDao {
    List<Ordering> selectAllPrd(SqlSession session, Integer gameNo);

    int insertOrdering(SqlSession session, Storage goods);

//    int insertOrdering(SqlSession session ,Goods inputGoods);
}
