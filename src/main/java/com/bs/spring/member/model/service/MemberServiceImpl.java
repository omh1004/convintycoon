package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dao.MemberDao;

import com.bs.spring.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private MemberDao dao;
    private SqlSession session;


//
    @Override
    public Member selectMemberById(String id) {
        return dao.findMemberById(session,id);
    }

    @Override
    public int saveMember(Member member) {


        return dao.saveMember(session,member);
    }
}
