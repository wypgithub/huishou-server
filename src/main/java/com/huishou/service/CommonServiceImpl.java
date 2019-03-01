package com.huishou.service;

import com.huishou.bean.AnalysisReportBean;
import com.huishou.constant.Constant;
import com.huishou.entity.*;
import com.huishou.repository.*;
import com.huishou.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p/>
 * <li>Description:公共Service实现</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommonServiceImpl implements CommonService {
    @Autowired
    private XueDuanRepository xueDuanRepository;
    @Autowired
    private XueNianRepository xueNianRepository;
    @Autowired
    private XueKeRepository xueKeRepository;
    @Autowired
    private ZhangJieRepository zhangJieRepository;
    @Autowired
    private ZhiShiDianRepository zhiShiDianRepository;
    @Autowired
    private ShiTiRepository shiTiRepository;
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ReportAnalysisService reportAnalysisService;


    @Override
    public List<XueDuan> findAllXd() {
        return xueDuanRepository.findAll();
    }

    @Override
    public List<List<List<XueKe>>> findAllXk(List<XueDuan> xds) {
        List<List<List<XueKe>>> result = new ArrayList<List<List<XueKe>>>();
        if (xds == null || xds.size() == 0) {
            return result;
        }
        for (XueDuan xd : xds) {
            List<List<XueKe>> firstXks = new ArrayList<List<XueKe>>();
            List<XueKe> xks = xueKeRepository.findByXdId(xd.getId());
            for (XueKe xk : xks) {
                //没喊显示三门学科
                if (firstXks.size() == 0 || firstXks.get(firstXks.size() - 1).size() == 3) {
                    firstXks.add(new ArrayList<XueKe>());
                }
                firstXks.get(firstXks.size() - 1).add(xk);
            }

            result.add(firstXks);
        }

        return result;
    }

    @Override
    public List<XueNian> findAllXn(Long xkId) {
        return xueNianRepository.findByXkId(xkId);
    }

    @Override
    public List<ZhangJie> findAllZj(Long xnId) {
        return zhangJieRepository.findByXnId(xnId);
    }

    @Override
    public List<ZhiShiDian> findAllZsd(Long zjId) {
        return zhiShiDianRepository.findByZjId(zjId);
    }

    @Override
    public List<ShiTi> findAllSt(Long zsdId) {
        return shiTiRepository.findByZsdId(zsdId);
    }

    @Override
    public Collection save(Collection collection, Long userId) {
        List<Collection> list = collectionRepository.findByTypeAndStIdAndUserId(collection.getType(), collection.getStId(),userId);
        if (list != null && list.size() > 0) {
            return null;
        }
        collection.setUserId(userId);
        collection.setCollectionTime(LocalDateTime.now());
        return collectionRepository.save(collection);
    }

    @Override
    public List<ShiTi> findUserCollection(Integer type, Long userId) {
        return shiTiRepository.findUserCollection(type, userId);
    }

    @Override
    public boolean answer(List<Answer> answers, Long userId) {
        if (CommonUtils.isEmptyList(answers)) {
            return false;
        }
        for (Answer answer : answers) {
            answer.setUserId(userId);
            answer.setStartTime(LocalDate.now());

            answerRepository.save(answer);
        }
        return true;

    }

    @Override
    public AnalysisReportBean loadReportData(String startDate, String endDate,Long userId) {
        AnalysisReportBean analysisReportBean = new AnalysisReportBean();
        //统计相关数据
        analysisReportBean.setAnswerSize(reportAnalysisService.countAnswerSize(startDate,endDate,userId,null));
        if(analysisReportBean.getAnswerSize() == 0){
            return analysisReportBean;
        }
        //时间段天数
        int days = Period.between( LocalDate.parse(startDate), LocalDate.parse(endDate)).getDays();
        analysisReportBean.setAvgDifficult(reportAnalysisService.countDifficult(startDate,endDate,userId,null));
        analysisReportBean.setTotalTime(reportAnalysisService.countAnswerTime(startDate,endDate,userId,null));
        analysisReportBean.setAvgTimePerDay(CommonUtils.formatDecimal(analysisReportBean.getTotalTime() / days,2));
        analysisReportBean.setAvgTime(
                CommonUtils.formatDecimal(analysisReportBean.getTotalTime() / analysisReportBean.getAnswerSize(),2));
        analysisReportBean.setCorrectRate(reportAnalysisService.countCorrectRate(startDate,endDate,userId,null));
        analysisReportBean.setChartData(reportAnalysisService.queryChartByZsdId(startDate,endDate,userId,null));
        /** 全部学生平均信息统计 **/
        analysisReportBean.setAllAvgAnswerSize(reportAnalysisService.countAnswerSize(startDate,endDate,null,null));
        analysisReportBean.setAllAvgCorrectRate(reportAnalysisService.countCorrectRate(startDate,endDate,null,null));
        analysisReportBean.setAllAvgDifficult(reportAnalysisService.countDifficult(startDate,endDate,null,null));
        analysisReportBean.setAllAvgTimePerDay(
                CommonUtils.formatDecimal(reportAnalysisService.countAnswerTime(startDate,endDate,null,null)/days,2));
        /** 按照学年知识点统计**/
        List<Map<String,Object>> xnMaps = new ArrayList<Map<String,Object>>();
        List<Object[]> xns = reportAnalysisService.queryXueNian(startDate,endDate,userId);
        for(Object[] xn:xns){
            Map<String,Object> xnMap = new HashMap<String,Object>();
            Long xnId = Long.valueOf(xn[0].toString());
            xnMap.put("xnName",xn[1]);
            xnMap.put("highlight", reportAnalysisService.queryHighlightByXnId(startDate,endDate,userId,xnId));
            xnMap.put("weak", reportAnalysisService.queryWeakByXnId(startDate,endDate,userId,xnId));
            List<Map<String,Object>> zsdMaps = new ArrayList<Map<String,Object>>();
            List<Object[]> zsds = reportAnalysisService.queryZsdByXnId(startDate,endDate,userId,xnId);
            for(Object[] zsd:zsds){
                Map<String,Object> zsdMap = new HashMap<String,Object>();
                Long zsdId = Long.valueOf(zsd[0].toString());
                zsdMap.put("zsdName",zsd[1]);
                zsdMap.put("chartData",reportAnalysisService.queryChartByZsdId(startDate,endDate,userId,zsdId));
                zsdMap.put("answerSize",reportAnalysisService.countAnswerSize(startDate,endDate,userId,zsdId));
                zsdMap.put("avgAnswerSize",reportAnalysisService.countAnswerSize(startDate,endDate,null,zsdId));
                zsdMap.put("correctRate",reportAnalysisService.countCorrectRate(startDate,endDate,userId,zsdId));
                zsdMap.put("avgCorrectRate",reportAnalysisService.countCorrectRate(startDate,endDate,null,zsdId));
                zsdMap.put("difficult",reportAnalysisService.countDifficult(startDate,endDate,userId,zsdId));
                zsdMap.put("avgDifficult",reportAnalysisService.countDifficult(startDate,endDate,null,zsdId));
                zsdMap.put("answerTime",reportAnalysisService.countAnswerTime(startDate,endDate,userId,zsdId));
                zsdMap.put("avgAnswerTime",reportAnalysisService.countAnswerTime(startDate,endDate,null,zsdId));
                zsdMaps.add(zsdMap);
            }
            xnMap.put("zsdInfo",zsdMaps);
            xnMaps.add(xnMap);
        }
        analysisReportBean.setSubInfo(xnMaps);
        return analysisReportBean;
    }
}
