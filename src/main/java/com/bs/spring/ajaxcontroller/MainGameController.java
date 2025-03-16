package com.bs.spring.ajaxcontroller;

import java.util.ArrayList;
import java.util.List;

import com.bs.spring.maingame.model.wrapper.RevenueWrapper;
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
  public ResponseEntity gameEnd(@RequestBody RevenueWrapper statement){
    System.out.println(statement.getRevenue());
    System.out.println(statement.getProduct());

//    int result = service.saveEndResult(statement.getRevenue());

    List<Storage> storageList = new ArrayList<>();

    statement.getProduct().forEach((p)-> {
      Storage s = Storage.builder()
              .orderingno(p.getOrderingNo())
              .goodsno(p.getGoodsNo())
              .playno(p.getPlayNo())
              .expdate(p.getExpDate() - 1)
              .orderquantity(p.getOrderQuantity())
              .saleprice((p.getExpDate() - 1) != 1 ? p.getSalePrice() : p.getSalePrice() / 2)
              .saledgree(p.getSaleDgree())
              .disposalyn((p.getExpDate() - 1) != 0 && p.getDisposalYN().equalsIgnoreCase("N") ? "n" : "y")
              .build();
      System.out.println(s);
      storageList.add(s);
    });
//       result2 += service.updateStorage(s);
//       count++;
//     });

    int result = service.saveRevenueAndUpdateStorage(statement.getRevenue(),storageList);

    if(result>0){
      return ResponseEntity.ok().build();
    }else{
      return ResponseEntity.badRequest().build();
    }
  }
}
