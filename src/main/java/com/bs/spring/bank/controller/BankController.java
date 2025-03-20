package com.bs.spring.bank.controller;

import com.bs.spring.bank.model.dto.Bank;
import com.bs.spring.bank.model.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("/getLoans")
    public ResponseEntity<List<Bank>> getUserLoans(@RequestParam String gameNo) {
        List<Bank> userLoans = bankService.getLoansByGameNo(gameNo);
        return ResponseEntity.ok(userLoans);
    }

    // ✅ 대출 신청 API
    @PostMapping("/applyLoan")
    public ResponseEntity<Map<String, Object>> applyLoan(@RequestBody Bank bank) {
        Map<String, Object> response = new HashMap<>();

        try {
            int result = bankService.insertLoan(bank);
            if (result > 0) {
                response.put("status", "success");
                response.put("message", "대출 신청 성공!");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "fail");
                response.put("message", "대출 신청 실패");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "서버 오류: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/getPlayday")
    public ResponseEntity<Integer> getPlayday(@RequestParam String gameNo) {
        int playday = bankService.getPlaydayByGameNo(gameNo);
        return ResponseEntity.ok(playday);
    }


    @GetMapping("/getDailyRevenue")
    public ResponseEntity<Map<String, Object>> getDailyRevenue(@RequestParam String gameNo, @RequestParam int selectedDay) {
        System.out.println("🔴 getDailyRevenue 실행: gameNo = " + gameNo + ", salesDay = " + selectedDay);
        Map<String, Object> revenueData = bankService.getDailyRevenue(gameNo, selectedDay);
        log.info("qwer1"+revenueData);
        return ResponseEntity.ok(revenueData);
    }

//    @RequestMapping("/moneydata")
//    public ResponseEntity moneyData(Integer gameNo){
//        log.info("gameNO+:::"+gameNo);
//        int money = service.getMoneyData(gameNo);
//        return ResponseEntity.ok().body(money);
//    }


    @GetMapping("/moneydata")
    public ResponseEntity<Integer> getMoneyData(@RequestParam("gameNo") String gameNo) {
        try {
            int cash = bankService.getGameCash(gameNo);
            return ResponseEntity.ok(cash);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0);
        }
    }


}
