package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dao.GoodsDao;
import com.bs.spring.member.model.dto.Goods;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService{

    private final GoodsDao goodsDao;
    private final SqlSession session;


    @Override
    public List<Goods> selectAllPrd(Goods goods) {


        List<Goods> result = goodsDao.selectAllPrd(session);

        return result;
    }
}
