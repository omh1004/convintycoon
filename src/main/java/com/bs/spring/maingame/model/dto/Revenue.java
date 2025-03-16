package com.bs.spring.maingame.model.dto;

public class Revenue {
  long salesDay;      // N일차
  long salesMount;    // 판매 수익
  int qeezeYN;        // 퀴즈 정답 여부
  int saleprice;      // 폐기수익
  int orderPriceAll;  // 발주 비용
  int cash;           // 잔고(N일차 시작 시)
  // (잔고+수익+지출) 로 정산표에 출력 예정
  // 아닌가? 게임 하는 동안 잔고가 변하니까 종료 시 잔고를 저장해야 하나?
  // 일단 보류... 다 저장하려면 DB도 조금 바꿔야 해서...
}
