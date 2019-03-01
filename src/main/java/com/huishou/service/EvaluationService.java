package com.huishou.service;

import com.huishou.entity.*;

import java.util.List;

/**
 * <p/>
 * <li>Description:测评Service</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
public interface EvaluationService {
    /**
     * 查询测评分类
     */
    List<EvalCategory> findCategory();
    /**
     * 查询分类下面测评信息
     */
    List<EvalInformation> findInformation(Long categoryId);
    /**
     * 查询测评题目
     */
    List<EvalTopic> findTopic(Long informationId);
    /**
     * 查询测评结果
     * */
    EvalResult findResult(Long informationId,Integer score);
}
