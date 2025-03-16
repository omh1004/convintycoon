package com.bs.spring.maingame.model.wrapper;

import com.bs.spring.maingame.model.dto.Product;
import com.bs.spring.maingame.model.dto.Revenue;
import com.bs.spring.member.model.dto.Storage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevenueWrapper {
    private Revenue revenue;
    private List<Product> product;
}
