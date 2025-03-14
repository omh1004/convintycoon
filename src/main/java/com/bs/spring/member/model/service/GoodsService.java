package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Ordering;

import java.util.List;

public interface GoodsService {
    List<Ordering> selectAllPrd();

//    int insertOrdering(List<Goods> goods);
}
