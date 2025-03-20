package com.bs.spring.ajaxcontroller;

import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Store;
import com.bs.spring.member.model.service.GoodsService;
import com.bs.spring.storage.model.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class StorageController {


    private final StorageService storageService;

    @GetMapping("/findStorageAll")
    public ResponseEntity<List<Store>> findStorageAll(Integer gameNo){
        log.info(" 요청 received: " );
        List<Store> result = storageService.findStorageAll(gameNo);

        Ordering subResult = storageService.selectGameInfo(gameNo);


        if(result.size()>0) {
            result.get(0).setStoragelevel(subResult.getStoragelevel());
            result.get(0).setAmount(subResult.getAmount());
            result.get(0).setPlayday(subResult.getPlayday());
            log.info("result결과::: " + result);
            log.info("result잔금결과::: " + subResult.getAmount() + subResult.getPlayday() + subResult.getStoragelevel());
        }
        if (result == null) {
            log.info(" 1. 상품전체조회");
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }



    @GetMapping("/gameInfo")
    public ResponseEntity<Ordering> gameInfo(Integer gameNo){

        Ordering subResult =   storageService.selectGameInfo(gameNo);

        if (subResult == null) {
            log.info(" 1. 상품전체조회");
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(subResult);
        }

    }

    @PostMapping("/expandStorage")
    public ResponseEntity<?> expandStorage() {
        try {
            return null;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Storage expansion failed: " + e.getMessage());
        }
    }




}
