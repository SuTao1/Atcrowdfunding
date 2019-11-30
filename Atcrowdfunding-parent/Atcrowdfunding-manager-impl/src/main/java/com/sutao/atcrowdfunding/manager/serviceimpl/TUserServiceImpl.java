package com.sutao.atcrowdfunding.manager.serviceimpl;

import com.sutao.atcrowdfunding.bean.TUser;
import com.sutao.atcrowdfunding.bean.TUserExample;
import com.sutao.atcrowdfunding.manager.mapper.TUserMapper;
import com.sutao.atcrowdfunding.manager.serviceapi.UserServiceApi;
import com.sutao.atcrowdfunding.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(value = "tUserServiceImpl")
public class TUserServiceImpl implements UserServiceApi {

    @Autowired(required = false)
    private TUserMapper tUserMapper;

    // 同步请求的操作
    /*@Override
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
    }*/
    /*异步请求的操作*/
    @Override
    public ResultUtils selectUserByInput(Map<String, Object> map) {
        TUserExample example = new TUserExample();
        example.createCriteria().andLoginacctEqualTo((String)map.get("loginacct"));
        List<TUser> list = tUserMapper.selectByExample(example);
        if (list != null && list.size() == 0){
            return new ResultUtils("没有该用户", 201, null, false);
        }
        assert list != null;
        String pswd = (String)map.get("loginpswd");
        String md5 = DigestUtils.md5DigestAsHex(pswd.getBytes());
        if(!list.get(0).getUserpswd().equals(md5)){
            return new ResultUtils("密码错误", 202, null, false);
        }
        return new ResultUtils("登陆成功", 200, list.get(0), true);
    }

    @Override
    public AjaxResult insertUser(TUser tUser) {
        AjaxResult result = null;
        result = this.selectUserByLoginacct(tUser.getLoginacct());
        if(!result.getSuccess()){
            return result;
        }
        String md5 = DigestUtils.md5DigestAsHex(tUser.getUserpswd().getBytes());
        tUser.setUserpswd(md5);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(Const.INSERT_USER_TIME_TYPE);
        String srtDate = dateFormat.format(date);
        tUser.setCreatetime(srtDate);
        int count = tUserMapper.insertSelective(tUser);
        if(count != 1){
            result = new AjaxResult();
            result.setSuccess(false);
            result.setMessage("注册失败");
            return result;
        }
        result = new AjaxResult();
        result.setMessage("注册成功");
        result.setSuccess(true);
        return result;
    }

    @Override
    public AjaxResult selectUserByLoginacct(String loginacct) {
        AjaxResult result = new AjaxResult();
        TUserExample example = new TUserExample();
        example.createCriteria().andLoginacctEqualTo(loginacct);
        List<TUser> list = tUserMapper.selectByExample(example);
        if(list != null && list.size() != 0){
            result.setSuccess(false);
            result.setMessage("该账户名已经存在~~");
            return result;
        }
        result.setSuccess(true);
        result.setMessage("账户名可用");
        return result;
    }
}
