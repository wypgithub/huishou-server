package com.huishou.interceptor;

import com.huishou.constant.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * <p/>
 * <li>Description:登录拦截检查</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/03  </li>
 * <li>@version: 1.0 </li>
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    Object useNameObj = request.getSession().getAttribute(Constant.CURRENT_LOGIN_USER);
    if(useNameObj == null){
      //未登陆跳转登录
      String redirectUrl = request.getContextPath().concat("/loginPage.do");
      if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
        //Ajax重定向
        response.setHeader("REDIRECT", "REDIRECT");
        //Ajax重定向的路径
        response.setHeader("CONTENTPATH", redirectUrl);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      }else{
        response.sendRedirect(redirectUrl);
      }

      return false;
    }

    return true;
  }

}
