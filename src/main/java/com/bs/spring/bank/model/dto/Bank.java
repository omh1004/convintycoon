package com.bs.spring.bank.model.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bank implements Serializable {
    private int loanNo;       // 대출번호
    private int memberNo;     // 사용자번호
    private String userId;    // 사용자 ID
    private int loanMoney;    // 대출금
    private Date loandate;    // 대출일자
}
