package com.huishou.repository;

import com.huishou.entity.XueNian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:学科Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface XueNianRepository extends JpaRepository<XueNian, Long> {
    @Query("select xn from XueNian xn where xn.xkId = ?1 and xn.enable = 1")
    public List<XueNian> findByXkId(Long xkId);
}
