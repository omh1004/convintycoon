package com.bs.spring.maingame.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    private Integer playNo;
    private Integer memberNo;
    private String userId;
    private Integer cash;
    private Integer loan;
    private Integer playDay;
    private Integer storageLevel;
    private Integer state;
    private Integer reliability;
}
