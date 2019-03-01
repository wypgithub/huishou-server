package com.huishou.service;

import java.util.List;

/**
 * <p/>
 * <li>Description:分析报告统计</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/09/10  </li>
 * <li>@version: 1.0 </li>
 */
public interface ReportAnalysisService {
    /**
     * 统计做过哪些学年
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param userId 用户ID
     * @return
     */
    List<Object[]> queryXueNian(String startDate, String endDate,Long userId);

    List<Object[]> queryHighlightByXnId(String startDate, String endDate,Long userId,Long xnId);

    List<Object[]> queryWeakByXnId(String startDate, String endDate,Long userId,Long xnId);

    List<Object[]> queryZsdByXnId(String startDate,String endDate,Long userId,Long xnId);

    List<Object[]> queryChartByZsdId(String startDate,String endDate,Long userId,Long zsdId);

    Double countAnswerSize(String startDate,String endDate,Long userId,Long zsdId);

    Double countCorrectRate(String startDate,String endDate,Long userId,Long zsdId);

    Double countDifficult(String startDate,String endDate,Long userId,Long zsdId);

    Double countAnswerTime(String startDate,String endDate,Long userId,Long zsdId);
}
