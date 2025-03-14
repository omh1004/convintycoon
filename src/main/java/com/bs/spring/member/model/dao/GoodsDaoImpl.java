package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao{
    @Override
    public List<Goods> selectAllPrd(SqlSession session) {
        return session.selectList("goods.selectAllPrd");
    }
}
