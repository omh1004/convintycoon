package com.bs.spring.ajaxcontroller;


import com.bs.spring.member.model.dto.Member;
import com.bs.spring.member.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class RestApiController {
//    private final BoardService boardService;
    private final MemberService memberService;
//
 //http://localhost:9090/spring/api/loginMember'
     @PostMapping("/enrollMember")
     public ResponseEntity<?> enrollMember(
             @RequestBody Member member
//             @RequestBody String userId,
//             @RequestBody String password,
//             @RequestBody String email,
//             @RequestBody String nick
//             @RequestParam(value = "Member", required = false) Member member
     ){
         log.info("member start"+member);
//         log.info("userId"+ userId.toString());
         //log.info("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡasdfaasdfasdfadss"+"nick: "+nick.toString()+"userId: "+userId.toString()+"password: "+password.toString()+"email: "+email.toString());

//         System.out.println("asdfaasdfasdfadss"+"nick"+nick+"userId"+userId+"password"+password+"email"+email);

         memberService.saveMember(member);



//       log.info("meeee:"+member1.toString());
         return ResponseEntity.status(HttpStatus.OK).body("그냥 성공");
     }

//    @GetMapping("/boards")
//    public List<Board> getMembers(@RequestParam(defaultValue="1")int cPage,
//                                  @RequestParam(defaultValue = "10") int numPerPage) {
//
//                List<Board> boards = boardService.findBoard(
//                        Map.of("cPage",cPage,"numPerPage",numPerPage));
//
//                    return boards;
//    }
//    @GetMapping("/boards/{boardNo}")
//    public Board getBoard(@PathVariable int boardNo) {
//        Board board = boardService.findBoardById(boardNo);
//        return board;
//    }

    @PostMapping("/loginMember")
    public ResponseEntity<Member> loginMember(@RequestBody Member member, HttpSession session){
        log.info("로그인 요청 received: " + member);

        Member result = memberService.findMemberById(member);

        if (result == null) {
            log.info("로그인 실패: 회원 정보를 찾을 수 없음");
            return ResponseEntity.notFound().build();
        } else {
            log.info("로그인 성공: " + result.getUserId());
            session.setAttribute("loginMember", result);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    @PostMapping("/findId")
    public ResponseEntity<Member> findId(@RequestBody Member member) {
        log.info("아이디찾기 요청 received: " + member);
        Member result = memberService.findId(member);
        log.info("아이디찾기 성공: " + result);

        if (result == null) {
            log.info("로그인 실패: 회원 정보를 찾을 수 없음");
            return ResponseEntity.notFound().build();
        } else {
            log.info("로그인 성공: " + result.getUserId());
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
     }


    @PostMapping("/checkId")
    public ResponseEntity<Map<String, Boolean>> checkId(@RequestBody Member member) {
        log.info("아이디찾기 요청 received: " + member);
        Member result = memberService.checkId(member);
        log.info("아이디찾기 성공: " + result);

        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", result != null);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/findPwd")
    public ResponseEntity<Member> findPwd(@RequestBody Member member){
        log.info("로그인 요청 received: " + member);


            Member result = memberService.findPwd(member);

            if (result == null) {
                log.info("비밀번호찾기 실패");
                // 유효성검사 실패
                return ResponseEntity.notFound().build();
            } else {
                log.info("비밀번호찾기 성공: " + result.getUserId());
                // DB 조회 성공
                return ResponseEntity.status(HttpStatus.OK).body(result);
            }

    }



//
//    //@ResponseEntity클래스를 이용해서 응답처리할 수 있음
//    @PostMapping("/member")
//    public Member createMember(@RequestBody Member member) {
//        log.debug("member: {}", member);
//        int result = memberService.saveMember(member);
//        return result > 0 ? member : null;
//    }
//




}
