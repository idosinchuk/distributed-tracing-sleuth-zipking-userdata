package com.idosinchuk.distributedtracing.userdata.service;

import com.idosinchuk.distributedtracing.userdata.dto.UserData;

public interface UserDataService {
    UserData getUserData(Integer userId);
}
