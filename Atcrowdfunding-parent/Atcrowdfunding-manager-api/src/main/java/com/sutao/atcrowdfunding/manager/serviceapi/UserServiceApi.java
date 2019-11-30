package com.sutao.atcrowdfunding.manager.serviceapi;

import com.sutao.atcrowdfunding.bean.TUser;

import java.util.Map;

public interface UserServiceApi {

    TUser selectUserByInput(Map<String, Object> map);

    int insertUser(TUser tUser);
}
