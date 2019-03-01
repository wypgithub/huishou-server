package com.huishou.repository;

import com.huishou.entity.EvalCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p/>
 * <li>Description:测评类别Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface EvalCategoryRepository extends JpaRepository<EvalCategory,Long> {

}
