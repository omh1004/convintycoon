package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemberService {
    public Member findMemberById(Member member);
    int saveMember(Member member);


    Member findId(Member member);

    Member findPwd(Member member);

    Member checkId(Member member);
}
