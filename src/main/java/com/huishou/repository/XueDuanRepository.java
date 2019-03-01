package com.huishou.repository;

import com.huishou.entity.XueDuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:学段Repository</li>
 * <li>@author: wyp </li>
 * <li>Date: 2018/7/1 </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface XueDuanRepository extends JpaRepository<XueDuan, Long> {
    @Override
    @Query("select xd from XueDuan xd where xd.enable = 1")
    List<XueDuan> findAll();

}
