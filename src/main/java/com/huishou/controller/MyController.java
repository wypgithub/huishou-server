package com.huishou.controller;

import com.huishou.bean.AnalysisReportBean;
import com.huishou.constant.Constant;
import com.huishou.entity.Collection;
import com.huishou.entity.ShiTi;
import com.huishou.service.CommonService;
import com.huishou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p/>
 * <li>Description:我的模块控制器</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Controller
@RequestMapping("/my")
public class MyController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;


    //我的
    @RequestMapping("/index.do")
    public String my(Model model){
        return "my/index";
    }

    //关于我们
    @RequestMapping("/aboutMe.do")
    public String aboutMe(){
        return "my/about_me";
    }

    //获取用户收藏
    @ResponseBody
    @RequestMapping("/getCollection.do")
    public List<ShiTi> getCollection(Integer type){
        return commonService.findUserCollection(type,getCurrentLoginUser().getId());
    }

    //退出登录
    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request){
        //移除登录信息
        request.getSession().removeAttribute(Constant.CURRENT_LOGIN_USER);
        //跳转登录页面
        return "login";
    }

    //充值中心
    @RequestMapping("/recharge.do")
    public String recharge(Model mode){
        mode.addAttribute("balance", userService.findAllById(getCurrentLoginUser().getId()).getBalance());
        return "my/recharge_center";
    }

    //导出学情报告
    @RequestMapping("/analysisReport.do")
    public String analysisReport(){
        return "my/analysisReport";
    }


    //加载报告数据
    @ResponseBody
    @RequestMapping("/loadReportData.do")
    public AnalysisReportBean loadReportData(String startDate,String endDate){
        return commonService.loadReportData(startDate,endDate,getCurrentLoginUser().getId());
    }





}