package com.bs.spring.storage.model.dao;

import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Store;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StorageDaoImpl implements StorageDao {

    @Override
    public List<Store> selectAllPrd(SqlSession session, Integer gameNo) {
        return session.selectList("storage.selectAllPrd",gameNo);
    }

    @Override
    public Ordering selectGameInfo(SqlSession session,Integer gameNo) {
        return session.selectOne("storage.selectGameInfo",gameNo);
    }
}
