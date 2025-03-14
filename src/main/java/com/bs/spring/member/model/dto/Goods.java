package com.bs.spring.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer goodno;
    private Integer orderavailable;
    private Integer typeexpdate;
    private Integer orderprice;
    private String goodstype;
    private String goodname;
}
