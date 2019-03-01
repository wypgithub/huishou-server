package com.huishou.repository;

import com.huishou.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:收藏Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface CollectionRepository extends JpaRepository<Collection,Long> {
    List<Collection> findByTypeAndUserId(Integer type,Long userId);

    List<Collection> findByTypeAndStIdAndUserId(Integer type,Long stId,Long userId);
}
