package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dao.GoodsDao;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Storage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService{

    private final GoodsDao goodsDao;
    private final SqlSession session;

    @Override
    public Ordering selectGameInfo(Integer gameNo) {
        return goodsDao.selectGameInfo(session,gameNo);
    }

    @Override
    public int insertOrdering(List<Storage> goods) {
        int result = 0;

        // 리스트 내 각 객체를 개별적으로 처리
        for (Storage storage : goods) {
            result += goodsDao.insertOrdering(session,storage);
        }

        return result;
    }

    @Override
    public List<Ordering> selectAllPrd(Integer gameNo) {
        List<Ordering> result = goodsDao.selectAllPrd(session, gameNo);
        return result;
    }


    /*
    *
    * 1. 상품 테이블에서 insert 할 상품의 상세정보를 가져온다.,
    * 2. 창고 테이블에 상품을 등록한다.
    *
    * */

//    @Override
//    public int insertOrdering(List<Goods> goods) {
//        for(int i=0;i<goods.size();i++){
//            Goods inputGoods = (Goods)goods.get(i);
//            int result = goodsDao.insertOrdering(session,inputGoods);
//        }
////        return null;
//    }
}
