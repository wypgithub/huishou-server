package com.huishou.repository;

import com.huishou.entity.ShiTi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p/>
 * <li>Description:试题Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface ShiTiRepository extends JpaRepository<ShiTi, Long> {
    @Query(value = "SELECT * FROM cs_stinfo st WHERE st.questionknowsid=?1 and st.stzt = 1 ORDER BY RAND() LIMIT 5",nativeQuery = true)
    List<ShiTi> findByZsdId(Long zsdId);

    @Query("select st from ShiTi st,Collection co where st.id = co.stId and co.type=?1 " +
            "and co.userId = ?2 and st.enable = 1")
    List<ShiTi> findUserCollection(Integer type,Long userId);
}
