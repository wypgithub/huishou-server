package com.huishou.repository;

import com.huishou.entity.ZhangJie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:章节Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface ZhangJieRepository extends JpaRepository<ZhangJie, Long> {
    List<ZhangJie> findByXnId(Long xnId);
}
