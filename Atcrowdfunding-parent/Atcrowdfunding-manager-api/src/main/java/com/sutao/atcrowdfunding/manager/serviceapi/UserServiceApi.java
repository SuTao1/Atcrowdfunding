package com.sutao.atcrowdfunding.manager.serviceapi;

import com.sutao.atcrowdfunding.bean.TUser;
import com.sutao.atcrowdfunding.utils.AjaxResult;
import com.sutao.atcrowdfunding.utils.ResultUtils;

import java.util.Map;

public interface UserServiceApi {
    // 同步请求的接口
    /*TUser selectUserByInput(Map<String, Object> map);*/
    ResultUtils selectUserByInput(Map<String, Object> map);

    AjaxResult insertUser(TUser tUser);

    AjaxResult selectUserByLoginacct(String loginacct);
}
