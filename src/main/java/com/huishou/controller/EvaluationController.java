package com.huishou.controller;

import com.huishou.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p/>
 * <li>Description:测评模块控制器</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Controller
@RequestMapping("/eval")
public class EvaluationController extends BaseController{
    @Autowired
    private EvaluationService evaluationService;

    /**
     * 检查是否可以进入
     */
    @ResponseBody
    @RequestMapping("/check.do")
    public boolean check(){
        return getCurrentLoginUser().getBalance() > 0;
    }

    /**
     * 测评类别
     * @param model
     */
    @RequestMapping("/index.do")
    public String index(Model model){
        model.addAttribute("category",evaluationService.findCategory());
        return "eval/category";
    }
    /**
     * 测评信息
     * @param model
     */
    @RequestMapping("/information.do")
    public String information(Model model,Long categoryId){
        model.addAttribute("information",evaluationService.findInformation(categoryId));
        return "eval/information";
    }
    /**
     * 测评题目
     * @param model
     */
    @RequestMapping("/topic.do")
    public String topic(Model model,Long informationId){
        model.addAttribute("topics",evaluationService.findTopic(informationId));
        return "eval/topic";
    }
    /**
     * 测评结果
     * @param model
     */
    @RequestMapping("/result.do")
    public String result(Model model,Long informationId,Integer score){
        model.addAttribute("results",evaluationService.findResult(informationId,score));
        return "eval/result";
    }
}
