package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Ordering;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao{
    @Override
    public List<Ordering> selectAllPrd(SqlSession session) {
        return session.selectList("ordering.selectAllPrd");
    }

//    @Override
//    public int insertOrdering(SqlSession session, Goods inputGoods) {
//        return session.insert("goods.insertOrdering",inputGoods);
//    }
}
