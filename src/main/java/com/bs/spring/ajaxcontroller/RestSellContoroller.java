package com.bs.spring.ajaxcontroller;


import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.service.GoodsService;
import com.bs.spring.member.model.service.GoodsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/ordering")
@RequiredArgsConstructor
@Slf4j
public class RestSellContoroller {

        /*
        *
        *  발주 기능
        *
        *  1. 상품전체조회
        *  2. 상품 발주 ->
        *       창고, 발주 테이블 insert
        * */

        // 1. 상품 전체 조회


        private final GoodsService goodsService;


        @RequestMapping("/selectAllPrd")
        public ResponseEntity<List<Goods>> selectAllPrd(@RequestBody Goods goods){
                log.info(" 요청 received: " + goods);
                List<Goods> result = goodsService.selectAllPrd(goods);
                log.info(" 1. 상품전체조회: " + result);

                if (result == null) {
                        log.info(" 1. 상품전체조회");
                        return ResponseEntity.notFound().build();
                } else {
//
                        return ResponseEntity.status(HttpStatus.OK).body(result);
                }
        }


}
