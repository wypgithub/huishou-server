package com.huishou.repository;

import org.hibernate.SQLQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * <p/>
 * <li>Description:动态数据库查询类实现</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/09/10  </li>
 * <li>@version: 1.0 </li>
 */
@Service
public class UtilsRepositoryServiceImpl<T> implements UtilsRepositoryService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<T> findBySql(String sql){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery(sql);
        //将查询结果转换成Map
        //query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<T> resultList = query.getResultList();
        entityManager.close();

        return resultList;
    }

    @Override
    public Object findSingleResultBySql(String sql) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery(sql);
        Object result = query.getSingleResult();
        entityManager.close();

        return result;
    }


}
