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
@RequestMapping("ordering")
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
                log.info("아이디찾기 요청 received: " + goods);
                List<Goods> result = goodsService.selectAllPrd(goods);
                log.info("아이디찾기 성공: " + result);

                if (result == null) {
                        log.info("로그인 실패: 회원 정보를 찾을 수 없음");
                        return ResponseEntity.notFound().build();
                } else {
//                        log.info("로그인 성공: " + result.getUserId());
                        return ResponseEntity.status(HttpStatus.OK).body(result);
                }
        }


}
