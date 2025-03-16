package com.bs.spring.maingame.model.service;

import com.bs.spring.maingame.model.dto.Revenue;
import com.bs.spring.member.model.dto.Goods;

public interface MainGameService {
  int saveEndResult(Revenue revenue);
  int updateStorage(Goods goods);
}
