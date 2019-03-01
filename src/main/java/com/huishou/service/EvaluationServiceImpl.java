package com.huishou.service;

import com.huishou.entity.EvalCategory;
import com.huishou.entity.EvalInformation;
import com.huishou.entity.EvalResult;
import com.huishou.entity.EvalTopic;
import com.huishou.repository.*;
import com.huishou.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p/>
 * <li>Description:测评Service实现</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvalCategoryRepository categoryRepository;
    @Autowired
    private EvalInformationRepository informationRepository;
    @Autowired
    private EvalTopicRepository topicRepository;
    @Autowired
    private EvalTopicOptionRepository optionRepository;
    @Autowired
    private EvalResultRepository resultRepository;


    @Override
    public List<EvalCategory> findCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<EvalInformation> findInformation(Long categoryId) {
        return informationRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<EvalTopic> findTopic(Long informationId) {
        List<EvalTopic> topics = topicRepository.findByInformationId(informationId);
        if(CommonUtils.isNotEmptyList(topics)){
            for (EvalTopic topic:topics){
                topic.setOption(optionRepository.findByTopicId(topic.getId()));
            }
        }
        return topics;
    }

    @Override
    public EvalResult findResult(Long informationId,Integer score) {
       List<EvalResult> results = resultRepository.findByInformationIdAndScore(informationId,score);
        //测评结果应该只有一条,防止脏数据这里取第一条
        if (CommonUtils.isNotEmptyList(results)){
            return results.get(0);
        }
        return null;
    }
}
