package com.huishou.service;

import com.huishou.bean.AnalysisReportBean;
import com.huishou.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p/>
 * <li>Description:公共Service</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
public interface CommonService {

    /**
     * 查询全部学段(启用)
     */
    List<XueDuan> findAllXd();

    /**
     * 查询全部学科(启用)
     * @return 全部学科
     */
    List<List<List<XueKe>>> findAllXk(List<XueDuan> xds);

    /**
     * 查询全部学年(启用)
     * @param kcId 课程ID
     * @return 课程下面全部学年
     */
    List<XueNian> findAllXn(Long kcId);

    /**
     * 查询全部章节
     * @param xnId 学年ID
     * @return 学年下面全部章节
     */
    List<ZhangJie> findAllZj(Long xnId);
    /**
     * 查询全部知识点
     * @param zjId 章节ID
     * @return 章节下面全部知识点
     */
    List<ZhiShiDian> findAllZsd(Long zjId);
    /**
     * 查询全部试题
     * @param zsdId 知识点ID
     * @return 知识点下面全部试题
     */
    List<ShiTi> findAllSt(Long zsdId);

    /**
     * 收藏
     * @param collection collection
     * @param userId 用户ID
     * @return Collection
     */
    Collection save(Collection collection,Long userId);
    /**
     * @param type 收藏类型
     * @param userId 用户ID
     * @return 收藏列表
     */
    List<ShiTi> findUserCollection(Integer type,Long userId);
    /**
     * 答题
     * @param answer 答题结果
     * @param userId 用户ID
     */
    boolean answer(List<Answer> answer,Long userId);


    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    AnalysisReportBean loadReportData(String startDate, String endDate,Long userId);





}
