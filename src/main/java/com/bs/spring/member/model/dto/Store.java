package com.bs.spring.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store {
    //해당 dto는 개인창고에 상품정보를 가져올때 사용한다.
    //만든이 : omh1004
    //join 정보, Goods, Storage
    private Integer goodsno;
    private String  goodstype;
    private String    goodsname;
    private Integer expdate;
    private Integer orderquantity;
    private String image;
    private Integer amount;
    private Integer storagelevel;
    private Integer playday;
}
