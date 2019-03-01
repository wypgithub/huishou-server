package com.huishou.controller;

import com.huishou.constant.Constant;
import com.huishou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p/>
 * <li>Description:Controller 基类</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Controller
public class BaseController {
    @Autowired
    private HttpServletRequest request;


    protected User getCurrentLoginUser(){
        Object user = request.getSession().getAttribute(Constant.CURRENT_LOGIN_USER);
        if(user!= null && user instanceof User){
            return (User)user;
        }
        return null;
    }
}
