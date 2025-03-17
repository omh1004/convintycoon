package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dao.MemberDao;

import com.bs.spring.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final MemberDao dao;

    private final SqlSession session;

    @Override
    public Member checkId(Member member) {
        log.info("service넘어옴"+member);
        return dao.checkId(session, member);
    }

//
//    @Override
//    public Member selectMemberById(SqlSession session ,String id) {
//        return dao.findMemberById(session,id);
//    }

    @Override
    public Member findMemberById(Member member) {
        log.info("service넘어옴"+member);
        return dao.findMemberById(session, member);
    }

    @Override
    public int saveMember(Member member) {
        return dao.saveMember(session,member);
    }

    @Override
    public Member findId(Member member) {
        System.out.println("memberService"+member);
        return dao.findId(session,member);
    }

    @Override
    public Member findPwd(Member member) {
        return dao.findPwd(session,member);
    }
}
