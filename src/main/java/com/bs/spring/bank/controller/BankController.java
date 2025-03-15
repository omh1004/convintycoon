package com.bs.spring.bank.controller;

import com.bs.spring.bank.model.dto.Bank;
import com.bs.spring.bank.model.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("/getLoans")
    public ResponseEntity<List<Bank>> getUserLoans(@RequestParam String userId) {
        List<Bank> userLoans = bankService.getLoansByUserId(userId);
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

}
