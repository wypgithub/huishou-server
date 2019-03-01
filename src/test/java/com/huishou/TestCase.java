package com.huishou;

import com.huishou.bean.AnalysisReportBean;
import com.huishou.service.CommonService;
import com.huishou.service.ReportAnalysisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * <p/>
 * <li>Description:</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/09/10  </li>
 * <li>@version: 1.0 </li>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCase {
    @Autowired
    private ReportAnalysisService reportAnalysisService;
    @Autowired
    private CommonService commonService;
    @Test
    public void test(){
        //Integer result =  reportAnalysisService.countAnswerSize("2018-9-1","2018-9-10",5L,1L);

        AnalysisReportBean reportBean = commonService.loadReportData("2018-09-09","2018-09-11",5L);


        System.out.println("-----测试完毕-------");

    }

}
