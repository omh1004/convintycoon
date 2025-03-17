package com.bs.spring.userdata.model.dao;

import com.bs.spring.userdata.model.dto.UserData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface UserDataDao {

    List<UserData> getUserRankings(SqlSession session);

    UserData getUserData(SqlSession session, @Param("userId") String userId);
}
