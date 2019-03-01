package com.huishou.controller;

import com.huishou.entity.User;
import com.huishou.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p/>
 * <li>Description:用户注册登录控制器</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/03  </li>
 * <li>@version: 1.0 </li>
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录页面
     */
    @RequestMapping("/registeredPage.do")
    public String registeredPage(){
        return "registered";
    }
    /**
     * 用户注册
     */
    @ResponseBody
    @RequestMapping(value = "/registered.do",method = RequestMethod.POST)
    public String registered(@RequestBody User user){
        return userService.registered(user);
    }
    /**
     * 登录页面
     */
    @RequestMapping("/loginPage.do")
    public String loginPage(){
        return "login";
    }
    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(@RequestBody User user,HttpServletRequest request){
        return userService.login(user,request);
    }
    /**
     * 忘记密码
     */
    @RequestMapping("/forgetPwd.do")
    public String  forgetPwd(){
        return "forget_pwd";
    }
    /**
     * 密码校验
     */
    @ResponseBody
    @RequestMapping(value = "/checkMiBao.do",method = RequestMethod.POST)
    public String checkMiBao(@RequestBody User user){
        user = userService.checkMiBao(user);
        if(user == null){
            return null;
        }
        return JSONObject.fromObject(user).toString();
    }
    /**
     * 重置
     */
    @ResponseBody
    @RequestMapping(value = "/resetPwd.do",method = RequestMethod.POST)
    public String resetPwd(@RequestBody User user){
        return userService.registered(user);
    }


}
