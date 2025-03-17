package com.bs.spring.userdata.model.service;

import com.bs.spring.userdata.model.dto.UserData;

import java.util.List;
import java.util.Map;

public interface UserDataService {

    List<UserData> getUserRankings();

    UserData getUserData(String userId);

}
