package com.huishou.repository;

import com.huishou.entity.EvalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:测评信息Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface EvalInformationRepository extends JpaRepository<EvalInformation,Long> {
    List<EvalInformation> findByCategoryId(Long categoryId);



}
