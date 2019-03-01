package com.huishou.repository;

import com.huishou.entity.EvalResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:测评结果Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface EvalResultRepository extends JpaRepository<EvalResult,Long> {

    /**
     * 根据测评信息ID和测评分数范围查询测评结果
     * @param informationId 测评信息ID
     * @param score 测评分数
     * @return List<EvalResult>
     */
    @Query("select ev from EvalResult ev where ev.informationId=?1 and ev.minScore <= ?2 and ev.maxScore > ?2")
    List<EvalResult> findByInformationIdAndScore(Long informationId,Integer score);

}
