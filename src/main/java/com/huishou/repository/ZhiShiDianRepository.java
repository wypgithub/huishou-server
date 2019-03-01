package com.huishou.repository;

import com.huishou.entity.ZhangJie;
import com.huishou.entity.ZhiShiDian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:知识点Repostory</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface ZhiShiDianRepository extends JpaRepository<ZhiShiDian, Long> {
    List<ZhiShiDian> findByZjId(Long zjId);
}
