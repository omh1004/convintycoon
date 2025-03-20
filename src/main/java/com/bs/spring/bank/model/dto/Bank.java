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
    private String loanType;  // 🔥 추가: 초기 운영 대출금 / 중간 운영 대출금
    private int gameNo;       // 🔥 추가: 게임 번호 (프론트에서 전달받음)
}
