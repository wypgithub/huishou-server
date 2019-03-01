package com.huishou.bean;

/**
 * <p/>
 * <li>Description:数据库查询返回对象</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/09/10  </li>
 * <li>@version: 1.0 </li>
 */

public class QueryResult {
    /**
     * 答题时间
     */
    private Integer answerDate;
    /**
     * 答题数量
     */
    private Integer answerSize;
    /**
     * 答题耗时
     */
    private Double answerTimes;
    /**
     * 答题正确率
     */
    private Double answerCorrectRate;
    /**
     * 答题难度
     */
    private Double answerDifficult;

    public QueryResult() {
    }


    public Integer getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Integer answerDate) {
        this.answerDate = answerDate;
    }

    public Integer getAnswerSize() {
        return answerSize;
    }

    public void setAnswerSize(Integer answerSize) {
        this.answerSize = answerSize;
    }

    public Double getAnswerTimes() {
        return answerTimes;
    }

    public void setAnswerTimes(Double answerTimes) {
        this.answerTimes = answerTimes;
    }

    public Double getAnswerCorrectRate() {
        return answerCorrectRate;
    }

    public void setAnswerCorrectRate(Double answerCorrectRate) {
        this.answerCorrectRate = answerCorrectRate;
    }

    public Double getAnswerDifficult() {
        return answerDifficult;
    }

    public void setAnswerDifficult(Double answerDifficult) {
        this.answerDifficult = answerDifficult;
    }
}
