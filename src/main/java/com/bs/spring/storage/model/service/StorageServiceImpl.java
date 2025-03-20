package com.bs.spring.storage.model.service;

import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Store;
import com.bs.spring.storage.model.dao.StorageDao;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {


    private final StorageDao storageDao;
    private final SqlSession session;


    @Override
    public List<Store> findStorageAll(Integer gameNo) {
        List<Store> result = storageDao.selectAllPrd(session, gameNo);
        return result;
    }

    @Override
    public Ordering selectGameInfo(Integer gameNo) {
        return storageDao.selectGameInfo(session,gameNo);
    }
}
