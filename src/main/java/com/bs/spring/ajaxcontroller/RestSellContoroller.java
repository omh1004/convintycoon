package com.bs.spring.ajaxcontroller;


import com.bs.spring.common.model.LoginMember;
import com.bs.spring.member.model.dto.Goods;
import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Storage;
import com.bs.spring.member.model.service.GoodsService;
import com.bs.spring.member.model.service.GoodsServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

        // 발주전체화면의 경우,
        // 상품테이블 상품번호 외래키로 하여 창고테이블의 상품번호와 조인함
        // 발주전체
        // 발주전체 조회시 , 게임정보에서 소지금,창고최대갯수 가져와야함

        @GetMapping("/selectAllPrd")
        public ResponseEntity<List<Ordering>> selectAllPrd(Integer gameNo){
                log.info(" 요청 received: " );
                List<Ordering> result = goodsService.selectAllPrd(gameNo);

                Ordering subResult = goodsService.selectGameInfo(gameNo);

                result.get(0).setStoragelevel(subResult.getStoragelevel());
                result.get(0).setAmount(subResult.getAmount());
                result.get(0).setPlayday(subResult.getPlayday());
                log.info("result결과::: "+result);

                if (result == null) {
                        log.info(" 1. 상품전체조회");
                        return ResponseEntity.notFound().build();
                } else {
                        return ResponseEntity.status(HttpStatus.OK).body(result);
                }
        }
//
//                 2. 상품 발주 ->창고, 발주 테이블 insert
        @PostMapping("/insertOrdering")
        public ResponseEntity<?> insertOrdering(@RequestBody List<Storage> goods) {
                log.info("요청 received: " + goods);

                // Service 계층에서 각 객체를 개별적으로 처리
                int result = goodsService.insertOrdering(goods);
                log.info("발주 등록 결과: " + result);

                if (result <= 0) {
                        log.info("발주등록 실패");
                        return ResponseEntity.notFound().build();
                } else {
                        return ResponseEntity.status(HttpStatus.OK).body(result);
                }
        }






}
