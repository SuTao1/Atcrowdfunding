package com.sutao.atcrowdfunding.controller;

import com.sutao.atcrowdfunding.bean.TUser;
import com.sutao.atcrowdfunding.manager.serviceapi.UserServiceApi;
import com.sutao.atcrowdfunding.utils.AjaxResult;
import com.sutao.atcrowdfunding.utils.Const;
import com.sutao.atcrowdfunding.utils.RegisterFailException;
import com.sutao.atcrowdfunding.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DispatcherController {

    @Autowired
    private UserServiceApi userServiceApi;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/reg")
    public String reg(){
        return "reg";
    }

    @RequestMapping(value = "/member")
    public String member(){
        return "member";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

    /*同步请求*/
    /*@RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String doLogin
            (@RequestParam("loginacct") String loginacct, @RequestParam("loginpswd") String loginpswd, @RequestParam("loginType") String type, HttpSession session){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginacct", loginacct);
        map.put("loginpswd", loginpswd);
        map.put("type", type);
        TUser user = userServiceApi.selectUserByInput(map);
        System.out.println(user.getUserpswd() + "   +++++++++++++++++++++");
        session.setAttribute(Const.LOGIN_USER, user);
        return "redirect:/main.htm";
    }*/
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult doLogin
    (@RequestParam("loginacct") String loginacct, @RequestParam("loginpswd") String loginpswd, @RequestParam("loginType") String type, HttpSession session){
        AjaxResult result = new AjaxResult();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("loginacct", loginacct);
            map.put("loginpswd", loginpswd);
            map.put("type", type);
            ResultUtils resultUtils = userServiceApi.selectUserByInput(map);
            session.setAttribute(Const.LOGIN_USER, resultUtils.getData());
            result.setSuccess(resultUtils.getState());
            result.setMessage(resultUtils.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("登陆失败");
            return result;
        }
        return result;
    }

    /*注册-同步请求*/
    /*@RequestMapping(value = "doRegister")
    public String register(TUser tUser){

        userServiceApi.insertUser(tUser);
        return "redirect:/login.htm";
    }*/

    /*注册-异步请求*/
    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult register(TUser tUser){
        AjaxResult result = null;
        try {
            result = userServiceApi.insertUser(tUser);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "系统错误");
            return result;
        }
        return result;
    }

    @RequestMapping(value = "loginacctVerification", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult loginacctVerification(String loginacct){
        AjaxResult result = null;
        try {
            result = userServiceApi.selectUserByLoginacct(loginacct);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "系统错误");
            return result;
        }
        return result;
    }
}
