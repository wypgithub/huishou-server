package com.huishou.service;

import com.huishou.repository.UtilsRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p/>
 * <li>Description:分析报告统计实现</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/09/10  </li>
 * <li>@version: 1.0 </li>
 */
@Service
public class ReportAnalysisServiceImpl implements ReportAnalysisService{
    @Autowired
    private UtilsRepositoryService utilsRepositoryService;

    @Override
    public List<Object[]> queryXueNian(String startDate, String endDate, Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT xn.xnid,CONCAT_WS('-',xd.xdmc,xk.xknr,xn.xnnr)");
        sql.append(getFromSql(startDate,endDate));
        sql.append(" AND aw.hyxh = "+userId);
        sql.append(" GROUP BY xn.xnid");

        return utilsRepositoryService.findBySql(sql.toString());
    }

    @Override
    public List<Object[]> queryHighlightByXnId(String startDate,String endDate,Long userId,Long xnId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT zsd.zsdmc");
        sql.append(getFromSql(startDate,endDate));
        sql.append(" AND aw.hyxh = "+userId);
        sql.append(" AND xn.xnid=" + xnId);
        sql.append(" GROUP BY zsd.zsdxh");
        sql.append(" HAVING (SUM(CASE WHEN aw.sfzq=1 THEN 1 ELSE 0 END) / COUNT(aw.ztxh)) >0.9");

        return utilsRepositoryService.findBySql(sql.toString());
    }

    @Override
    public List<Object[]> queryWeakByXnId(String startDate, String endDate,Long userId,Long xnId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT zsd.zsdmc");
        sql.append(getFromSql(startDate,endDate));
        sql.append(" AND aw.hyxh = "+userId);
        sql.append(" AND xn.xnid=" + xnId);
        sql.append(" GROUP BY zsd.zsdxh");
        sql.append(" HAVING (SUM(CASE WHEN aw.sfzq=1 THEN 1 ELSE 0 END) / COUNT(aw.ztxh)) <0.3");

        return utilsRepositoryService.findBySql(sql.toString());
    }

    @Override
    public List<Object[]> queryZsdByXnId(String startDate, String endDate,Long userId,Long xnId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT zsd.zsdxh,CONCAT_WS('-',xd.xdmc,xk.xknr,xn.xnnr,zj.xknr,zsd.zsdmc)");
        sql.append(getFromSql(startDate,endDate));
        sql.append(" AND aw.hyxh = "+userId);
        sql.append(" AND xn.xnid=" + xnId);
        sql.append(" GROUP BY xn.xnid");

        return utilsRepositoryService.findBySql(sql.toString());
    }

    @Override
    public List<Object[]> queryChartByZsdId(String startDate, String endDate, Long userId, Long zsdId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT aw.kssj,COUNT(aw.ztxh),SUM(aw.ztsc)," +
                "ROUND(100*SUM(CASE WHEN aw.sfzq=1 THEN 1 ELSE 0 END)/COUNT(aw.ztxh))");
        sql.append(getFromSql(startDate,endDate));
        sql.append(" AND aw.hyxh = " + userId);
        if(zsdId != null){
            sql.append(" AND zsd.zsdxh=" + zsdId);
        }
        sql.append(" GROUP BY aw.kssj");

        return utilsRepositoryService.findBySql(sql.toString());
    }

    @Override
    public Double countAnswerSize(String startDate, String endDate, Long userId, Long zsdId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ROUND(COUNT(ztxh)/COUNT(DISTINCT hyxh),2)");
        sql.append(getFromZsdSql(startDate,endDate,userId,zsdId));

        Object result = utilsRepositoryService.findSingleResultBySql(sql.toString());

        return result==null? 0 :Double.valueOf(result.toString());
    }

    @Override
    public Double countCorrectRate(String startDate, String endDate, Long userId, Long zsdId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ROUND(SUM(CASE WHEN aw.sfzq=1 THEN 1 ELSE 0 END)/COUNT(aw.ztxh),2)");
        sql.append(getFromZsdSql(startDate,endDate,userId,zsdId));

        Object result = utilsRepositoryService.findSingleResultBySql(sql.toString());

        return result==null? 0 :Double.valueOf(result.toString());
    }

    @Override
    public Double countDifficult(String startDate, String endDate, Long userId, Long zsdId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ROUND(AVG(st.stnd),2)");
        sql.append(getFromZsdSql(startDate,endDate,userId,zsdId));

        Object result = utilsRepositoryService.findSingleResultBySql(sql.toString());

        return result==null? 0 :Double.valueOf(result.toString());
    }

    @Override
    public Double countAnswerTime(String startDate, String endDate, Long userId, Long zsdId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ROUND(SUM(aw.ztsc)/COUNT(DISTINCT aw.hyxh),2)");
        sql.append(getFromZsdSql(startDate,endDate,userId,zsdId));

        Object result = utilsRepositoryService.findSingleResultBySql(sql.toString());

        return result==null? 0 :Double.valueOf(result.toString());
    }


    private String getFromSql(String startDate, String endDate){
        return " FROM yw_hyztlog aw,cs_stinfo st,cs_zsdinfo zsd,cs_zjinfo zj," +
                " cs_xninfo xn,cs_xkinfo xk,cs_xdinfo xd" +
                " WHERE aw.stxh = st.questionid and st.questionknowsid = zsd.zsdxh" +
                " AND zsd.ylzj=zj.zjid AND zj.ylxn=xn.xnid AND xn.xkid = xk.xkid " +
                " AND xk.xdid = xd.xdid AND aw.kssj>= '"+ startDate +"' AND aw.kssj<= '" + endDate+"'";
    }
    private String getFromZsdSql(String startDate, String endDate,Long userId, Long zsdId){
        StringBuilder sql = new StringBuilder("FROM yw_hyztlog aw,cs_stinfo st" +
                " WHERE aw.stxh = st.questionid" +
                " AND aw.kssj>= '"+ startDate +"' AND aw.kssj<= '" + endDate+"'");
        if(userId != null){
            sql.append(" AND aw.hyxh = " + userId);
        }
        if(zsdId != null){
            sql.append(" AND st.questionknowsid=" + zsdId);
        }
        return sql.toString();
    }
}
