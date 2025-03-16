package com.bs.spring.maingame.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer orderingNo;
    private Integer goodsNo;
    private Integer playNo;
    private String goodType;
    private String goodsName;
    private String image;
    private Integer expDate;
    private Integer orderQuantity;
    private Integer salePrice;
    private Integer saleDgree;
    private String disposalYN;
}
