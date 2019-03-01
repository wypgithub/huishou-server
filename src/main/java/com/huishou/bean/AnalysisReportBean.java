package com.huishou.bean;

import java.util.List;
import java.util.Map;

/**
 * 学情报告统计对象
 */
public class AnalysisReportBean {

    /**
     * 总共做题数目
     * */
    private double answerSize;
    /**
     * 平均难度
     * */
    private double avgDifficult;
    /**
     * 耗时(分)
     * */
    private double totalTime;
    /**
     * 平均每天耗时(分)
     * */
    private double avgTimePerDay;
    /**
     * 平均每题耗时(分)
     * */
    private double avgTime;
    /**
     * 正确率
     * */
    private double correctRate;
    /**
     * 图形数据
     * * */
    private List<Object[]> chartData;
    /**
     * 全部用户平均做题数目
     * */
    private double allAvgAnswerSize;
    /**
     * 全部用户平均做题难度
     * */
    private double allAvgDifficult;
    /**
     * 全部用户平均耗时(分)
     * */
    private double allAvgTimePerDay;
    /**
     * 全部用户平均正确率
     * */
    private double allAvgCorrectRate;
    /**
     * 学年知识点信息
     * */
    private List<Map<String,Object>> subInfo;


    public List<Map<String, Object>> getSubInfo() {
        return subInfo;
    }

    public void setSubInfo(List<Map<String, Object>> subInfo) {
        this.subInfo = subInfo;
    }

    public double getAnswerSize() {
        return answerSize;
    }

    public void setAnswerSize(double answerSize) {
        this.answerSize = answerSize;
    }

    public double getAvgDifficult() {
        return avgDifficult;
    }

    public void setAvgDifficult(double avgDifficult) {
        this.avgDifficult = avgDifficult;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getAvgTimePerDay() {
        return avgTimePerDay;
    }

    public void setAvgTimePerDay(double avgTimePerDay) {
        this.avgTimePerDay = avgTimePerDay;
    }

    public double getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(double avgTime) {
        this.avgTime = avgTime;
    }

    public double getCorrectRate() {
        return correctRate;
    }

    public void setCorrectRate(double correctRate) {
        this.correctRate = correctRate;
    }

    public List<Object[]> getChartData() {
        return chartData;
    }

    public void setChartData(List<Object[]> chartData) {
        this.chartData = chartData;
    }

    public double getAllAvgAnswerSize() {
        return allAvgAnswerSize;
    }

    public void setAllAvgAnswerSize(double allAvgAnswerSize) {
        this.allAvgAnswerSize = allAvgAnswerSize;
    }

    public double getAllAvgDifficult() {
        return allAvgDifficult;
    }

    public void setAllAvgDifficult(double allAvgDifficult) {
        this.allAvgDifficult = allAvgDifficult;
    }

    public double getAllAvgTimePerDay() {
        return allAvgTimePerDay;
    }

    public void setAllAvgTimePerDay(double allAvgTimePerDay) {
        this.allAvgTimePerDay = allAvgTimePerDay;
    }

    public double getAllAvgCorrectRate() {
        return allAvgCorrectRate;
    }

    public void setAllAvgCorrectRate(double allAvgCorrectRate) {
        this.allAvgCorrectRate = allAvgCorrectRate;
    }
}




