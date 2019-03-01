package com.huishou.entity;

import javax.persistence.*;

/**
 * <p/>
 * <li>Description:测评结果</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_cpjgxx")
public class EvalResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "jgxh")
    private Long id;
    /**
     * 测评信息ID
     */
    @Column(nullable = false,name = "cpxh")
    private Long informationId;
    /**
     * 分数范围 最小值
     */
    @Column(nullable = false,name = "minfs")
    private Integer minScore;
    /**
     * 分数范围 最大值
     */
    @Column(nullable = false,name = "maxfs")
    private Integer maxScore;
    /**
     * 测评结果
     */
    @Column(nullable = false,name = "cpjg")
    private String result;
    /**
     * 免责声明
     */
    @Column(nullable = false,name = "mzsm")
    private String statement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInformationId() {
        return informationId;
    }

    public void setInformationId(Long informationId) {
        this.informationId = informationId;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
