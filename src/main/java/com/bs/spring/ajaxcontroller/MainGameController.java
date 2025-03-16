package com.bs.spring.ajaxcontroller;

import java.util.List;

import com.bs.spring.member.model.dto.Storage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.spring.maingame.model.dto.Revenue;
import com.bs.spring.maingame.model.service.MainGameService;
import com.bs.spring.member.model.dto.Goods;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maingame")
@CrossOrigin("*")
public class MainGameController {
  private final MainGameService service;

  @RequestMapping("/gameend")
  public ResponseEntity gameEnd(@RequestBody Revenue revenue){
//          @RequestBody List<Storage> storage){
    int result = service.saveEndResult(revenue);
//    int result2 = 0;
//    int count = 0;
    // product.forEach((p)->{
    //   result2 += service.updateStorage(p);
    //   count++;
    // });

    if(result>0){
      return ResponseEntity.ok().build();
    }else{
      return ResponseEntity.noContent().build();
    }
  }
}
