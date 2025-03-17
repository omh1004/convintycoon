package com.bs.spring.maingame.model.dao;

import com.bs.spring.maingame.model.dto.Game;
import com.bs.spring.maingame.model.dto.Product;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Storage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.maingame.model.dto.Revenue;

import java.util.List;

@Repository
public class MainGameDaoImpl implements MainGameDao {
    @Override
    public int newGame(SqlSession session, Game game){
        return session.insert("maingame.newGame");
//        return 0;
    }

    @Override
    public List<Product> getAllProductByGameNo(SqlSession session, Integer gameNo){
        return session.selectList("maingame.getAllProductByGameNo",gameNo);
//      return null;
    }

  @Override
  public int saveEndResult(SqlSession session, Revenue revenue){
     return session.insert("maingame.saveEndResult",revenue);
//    return 0;
  }

  @Override
  public int updateStorage(SqlSession session, Storage storage) {
     return session.update("maingame.updateStorage",storage);
//    return 0;
  }


}
