package com.idosinchuk.distributedtracing.userdata.service;

import com.idosinchuk.distributedtracing.userdata.dto.UserDataDTO;

public interface UserDataService {
    UserDataDTO getUserData(Integer userId) throws Exception;
}
