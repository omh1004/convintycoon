package com.bs.spring.userdata.model.service;

import com.bs.spring.userdata.model.dao.UserDataDao;
import com.bs.spring.userdata.model.dto.UserData;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserDataDao userDataDao;
    private final SqlSession session;

    @Override
    public List<UserData> getUserRankings() {
        return userDataDao.getUserRankings(session);
    }

    @Override
    public UserData getUserData(String userId) {
        return userDataDao.getUserData(session, userId);
    }

}
