package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "memberdao")
public class MemberDaoImpl implements MemberDao {

    @Override
    public Member findMemberById(SqlSession session, String id) {
        Member member = session.selectOne("member.findMemberById", id);
        return member;
    }

    public int saveMember(SqlSession session, Member member) {

        return session.insert("member.saveMember", member);
    }

}
