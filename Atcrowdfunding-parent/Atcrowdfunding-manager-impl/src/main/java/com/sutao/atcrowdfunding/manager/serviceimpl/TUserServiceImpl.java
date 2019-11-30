package com.sutao.atcrowdfunding.manager.serviceimpl;

import com.sutao.atcrowdfunding.bean.TUser;
import com.sutao.atcrowdfunding.bean.TUserExample;
import com.sutao.atcrowdfunding.manager.mapper.TUserMapper;
import com.sutao.atcrowdfunding.manager.serviceapi.UserServiceApi;
import com.sutao.atcrowdfunding.utils.LoginFailException;
import com.sutao.atcrowdfunding.utils.RegisterFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

@Service(value = "tUserServiceImpl")
public class TUserServiceImpl implements UserServiceApi {

    @Autowired(required = false)
    private TUserMapper tUserMapper;

    @Override
    public TUser selectUserByInput(Map<String, Object> map) {
        TUserExample example = new TUserExample();
        example.createCriteria().andLoginacctEqualTo((String)map.get("loginacct"));
        List<TUser> list = tUserMapper.selectByExample(example);
        if (list != null && list.size() == 0){
            throw new LoginFailException("没有找到该用户");
        }
        assert list != null;
        String pswd = (String)map.get("loginpswd");
        String md5 = DigestUtils.md5DigestAsHex(pswd.getBytes());
        if(!list.get(0).getUserpswd().equals(md5)){
            throw new LoginFailException("密码错误");
        }
        return list.get(0);
    }

    @Override
    public int insertUser(TUser tUser) {
        String md5 = DigestUtils.md5DigestAsHex(tUser.getUserpswd().getBytes());
        tUser.setUserpswd(md5);
        int count = tUserMapper.insertSelective(tUser);
        if(count != 1){
            throw new RegisterFailException("注册失败！");
        }
        return count;
    }
}
