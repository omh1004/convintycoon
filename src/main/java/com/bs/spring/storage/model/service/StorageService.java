package com.bs.spring.storage.model.service;

import com.bs.spring.member.model.dto.Ordering;
import com.bs.spring.member.model.dto.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StorageService {
    List<Store> findStorageAll(Integer gameNo);

    Ordering selectGameInfo(Integer gameNo);
}
