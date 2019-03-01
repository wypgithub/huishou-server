package com.huishou.controller;

import com.huishou.constant.Constant;
import com.huishou.entity.Answer;
import com.huishou.entity.Collection;
import com.huishou.entity.ShiTi;
import com.huishou.entity.XueDuan;
import com.huishou.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p/>
 * <li>Description:答题模块控制器</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController{
    @Autowired
    private CommonService commonService;

    //首页
    @RequestMapping("/index.do")
    public String findAllXd(Model model){
        List<XueDuan> xds= commonService.findAllXd();
        model.addAttribute("xds",xds);
        model.addAttribute("xks",commonService.findAllXk(xds));
        return "index/index";
    }

    //选择学年
    @RequestMapping("/chooseXn.do")
    public String chooseXn(Long kcId,Model model){
        model.addAttribute("xns",commonService.findAllXn(kcId));
        return "index/choose_xn";
    }

    //选择章节
    @RequestMapping("/chooseZj.do")
    public String chooseZj(Long xnId,Model model){
        model.addAttribute("zjs",commonService.findAllZj(xnId));
        return "index/choose_zj";
    }

    //选择知识点
    @RequestMapping("/chooseZsd.do")
    public String chooseZsd(Long zjId,Model model){
        model.addAttribute("zsds",commonService.findAllZsd(zjId));
        return "index/choose_zsd";
    }

    //选择试题
    @RequestMapping("/chooseSt.do")
    public String chooseSt(Long zsdId,Model model){
        model.addAttribute("zsdId",zsdId);
        model.addAttribute("questions",commonService.findAllSt(zsdId));
        return "index/answer";
    }

    //选择试题
    @RequestMapping("/report.do")
    public String report(){
        return "index/report";
    }

    //收藏
    @ResponseBody
    @RequestMapping("/collection.do")
    public boolean collection(@RequestBody Collection collection){
        return commonService.save(collection,getCurrentLoginUser().getId()) != null;
    }

    //答题
    @ResponseBody
    @RequestMapping("/answer.do")
    public boolean answer(@RequestBody List<Answer> answer){
       return commonService.answer(answer,getCurrentLoginUser().getId());
    }
}
