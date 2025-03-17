package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository(value = "memberdao")
public class MemberDaoImpl implements MemberDao {

    @Override
    public Member findMemberById(SqlSession session, Member member) {
        Member result = session.selectOne("member.findMemberById", member);
        return result;
    }

    @Override
    public Member checkId(SqlSession session, Member member) {
        Member result = session.selectOne("member.checkId", member);
        return result;
    }

    public int saveMember(SqlSession session, Member member) {

        return session.insert("member.saveMember", member);
    }

    @Override
    public Member findId(SqlSession session,Member member) {
        System.out.println("memberDAO"+member);

        Member output = session.selectOne("member.findId", member);

        log.info("memberInfo"+output);

        return output;


    }

    @Override
    public Member findPwd(SqlSession session, Member member) {
        return session.selectOne("member.findPwd", member);
    }

}
