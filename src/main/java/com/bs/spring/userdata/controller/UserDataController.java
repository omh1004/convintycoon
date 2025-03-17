package com.bs.spring.userdata.controller;

// 이 클래스는 랭킹 조회와 저장된 게임 데이터를 구현하기 위해 구성한 패키지입니다.
// 현재 다른 팀원이 사용중인 member 패키지와 공동작업으로 인해 conflict가 발생하는걸 방지하기 위해 생성하였습니다.

import com.bs.spring.userdata.model.dto.UserData;
import com.bs.spring.userdata.model.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/userdata")
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataService userDataService;

    @GetMapping("/getRankings")
    public ResponseEntity<List<UserData>> getUserRankings() {
        List<UserData> rankings = userDataService.getUserRankings();
        return ResponseEntity.ok(rankings);
    }

    // 불러오기 기능: 특정 유저의 저장된 게임 데이터를 가져옴
    @GetMapping("/getUserData")
    public UserData getUserData(@RequestParam String userId) {
        return userDataService.getUserData(userId);
    }
}
