package com.huishou.repository;

import com.huishou.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.geom.Arc2D;
import java.util.List;

/**
 * <p/>
 * <li>Description:答题Repository</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{
    @Query(value = "SELECT COUNT(ztxh) FROM yw_hyztlog WHERE kssj>=?1 AND kssj<=?2 AND hyxh=?3" ,nativeQuery = true)
    Integer countAnswerSize(String startDate, String endDate,Long userId);

    @Query(value = "SELECT AVG(info.stnd) FROM yw_hyztlog zt,cs_stinfo info WHERE zt.stxh = info.questionid" +
            " AND zt.kssj>=?1 AND zt.kssj<=?2 AND zt.hyxh=?3",nativeQuery = true)
    Double countAvgDifficult(String startDate, String endDate,Long userId);

    @Query(value = "SELECT SUM(zt.ztsc) FROM yw_hyztlog zt WHERE zt.kssj>=?1 AND zt.kssj<=?2 AND zt.hyxh=?3",nativeQuery = true)
    Double countTotalTime(String startDate, String endDate,Long userId);

    @Query(value = "SELECT COUNT(zt.ztxh) FROM yw_hyztlog zt WHERE zt.kssj>=?1 AND zt.kssj<=?2" +
            " AND zt.sfzq=1 AND zt.hyxh=?3",nativeQuery = true)
    Integer countCorrectSize(String startDate, String endDate, Long userId);

    @Query(value = "SELECT zt.kssj,COUNT(zt.ztxh) FROM yw_hyztlog zt WHERE zt.kssj>=?1" +
            " AND zt.kssj<=?2 AND zt.hyxh=?3 GROUP BY zt.kssj",nativeQuery = true)
    List countAnswerSizePerDay(String startDate, String endDate,Long userId);

    @Query(value = "SELECT zt.kssj,SUM(zt.ztsc) FROM yw_hyztlog zt WHERE zt.kssj>=?1" +
            " AND zt.kssj<=?2 AND zt.hyxh=?3 GROUP BY zt.kssj",nativeQuery = true)
    List countAvgTimePerDay(String startDate, String endDate,Long userId);

    @Query(value = "SELECT zt.kssj,ROUND(100*SUM(CASE WHEN zt.sfzq=1 THEN 1 ELSE 0 END) / COUNT(zt.ztxh))" +
            " FROM yw_hyztlog zt" +
            " WHERE zt.kssj>=?1 AND zt.kssj<=?2 AND zt.hyxh=?3 GROUP BY zt.kssj",nativeQuery = true)
    List countCorrectRatePerDay(String startDate, String endDate,Long userId);

    @Query(value = "SELECT AVG(sub.si) FROM (SELECT COUNT(zt.ztxh) AS si FROM yw_hyztlog zt WHERE zt.kssj>=?1 AND zt.kssj<=?2 GROUP BY zt.hyxh)sub" ,nativeQuery = true)
    Integer countAllAvgAnswerSize(String startDate, String endDate);

    @Query(value = "SELECT AVG(sub.si) FROM (SELECT COUNT(zt.ztxh) AS si FROM yw_hyztlog zt WHERE zt.kssj>=?1 AND zt.kssj<=?2 " +
            " AND zt.sfzq=1 GROUP BY zt.hyxh)sub" ,nativeQuery = true)
    Integer countAllAvgCorrectSize(String startDate, String endDate);

    @Query(value = "SELECT AVG(sub.di) FROM (SELECT AVG(info.stnd) AS di FROM yw_hyztlog zt,cs_stinfo info WHERE zt.stxh = info.questionid" +
            " AND zt.kssj>=?1 AND zt.kssj<=?2 GROUP BY zt.hyxh)sub",nativeQuery = true)
    Double countAllAvgDifficult(String startDate, String endDate);

    @Query(value = "SELECT AVG(sub.ztsc) FROM (SELECT SUM(zt.ztsc) AS ztsc FROM yw_hyztlog zt WHERE zt.kssj>=?1" +
            " AND zt.kssj<=?2 GROUP BY zt.hyxh)sub",nativeQuery = true)
    Double countAllTotalTime(String startDate, String endDate);

}
