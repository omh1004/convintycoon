package com.bs.spring.maingame.model.service;

import com.bs.spring.maingame.model.dto.Game;
import com.bs.spring.maingame.model.dto.Product;
import com.bs.spring.maingame.model.dto.Revenue;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Storage;

import java.util.List;

public interface MainGameService {
  int saveRevenueAndUpdateStorage(Revenue revenue, List<Storage> storage);
  List<Product> getAllProductByGameNo(Integer gameNo);
  int newGame(Game game);
//  int saveEndResult(Revenue revenue);
//  int updateStorage(Storage storage);
}
