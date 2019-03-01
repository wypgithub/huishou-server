package com.huishou.repository;

import java.util.List;
import java.util.Map;

/**
 * <p/>
 * <li>Description:动态数据库查询类</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/09/10  </li>
 * <li>@version: 1.0 </li>
 */

public interface UtilsRepositoryService<T> {
    /**
     * <p/>
     * <li>Description: 原生SQL查询,返回Map结构</li>
     */
    List<T> findBySql (String sql);


    Object findSingleResultBySql ( String sql );
}
