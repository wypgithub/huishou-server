package com.huishou.repository;

import com.huishou.entity.EvalTopicOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:测评题目Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface EvalTopicOptionRepository extends JpaRepository<EvalTopicOption,Long> {
    List<EvalTopicOption> findByTopicId(Long topicId);

}
