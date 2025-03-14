package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectAllPrd(Goods goods);
}
