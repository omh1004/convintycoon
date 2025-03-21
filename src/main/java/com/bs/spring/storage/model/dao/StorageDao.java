package com.bs.spring.storage.model.dao;

import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Store;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface StorageDao {
    List<Store> selectAllPrd(SqlSession session, Integer gameNo);

    Ordering selectGameInfo(SqlSession session, Integer gameNo);
}
