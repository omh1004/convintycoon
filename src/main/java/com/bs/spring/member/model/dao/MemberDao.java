package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberDao {
    Member findMemberById(SqlSession session, Member member);

    int saveMember(SqlSession session, Member member);

    Member findId(SqlSession session,Member member);

    Member findPwd(SqlSession session, Member member);

    Member checkId(SqlSession session, Member member);
}
