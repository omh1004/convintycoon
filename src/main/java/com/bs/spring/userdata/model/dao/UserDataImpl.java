package com.bs.spring.userdata.model.dao;

import com.bs.spring.userdata.model.dto.UserData;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataImpl implements UserDataDao {

    @Override
    public List<UserData> getUserRankings(SqlSession session) {
        return session.selectList("userdata.getUserRankings");
    }

    @Override
    public UserData getUserData(SqlSession session, String userId) {
        return session.selectOne("userdata.getUserData", userId);
    }
}
