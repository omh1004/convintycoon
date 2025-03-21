package com.bs.spring.member.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Storage {
    private Integer orderingno;
    private Integer goodsno;
    private Integer playno;
    private Integer expdate;
    private Integer orderquantity;
    private Integer saleprice;
    private Integer saledgree;
    private String  disposalyn;
    private Integer expyn;
    private Integer cash;
}


