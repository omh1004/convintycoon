package com.bs.spring.maingame.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Revenue {
  Integer playNo;        // 게임번호
  Integer salesDay;      // N일차
  Integer salesMount;    // 판매 수익
  String qeezeYN;        // 퀴즈 정답 여부
  String feverYN;       // 피버타임
  int disposePrice;   // 폐기수익
  int orderPrice;     // 발주 비용
  int dayendcash;     // 잔고(N일차 시작 시)
  // (잔고+수익+지출) 로 정산표에 출력 예정
  // 아닌가? 게임 하는 동안 잔고가 변하니까 종료 시 잔고를 저장해야 하나?
  // 일단 보류... 다 저장하려면 DB도 조금 바꿔야 해서...
}
