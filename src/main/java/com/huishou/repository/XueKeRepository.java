package com.huishou.repository;

import com.huishou.entity.XueKe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:课程Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface XueKeRepository extends JpaRepository<XueKe, Long> {
    @Query("select xk from XueKe xk where xk.xdId = ?1 and xk.enable = 1")
    List<XueKe> findByXdId(Long xdId);

}
