package com.huishou.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p/>
 * <li>Description:试题</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "cs_stinfo")
public class ShiTi implements Serializable {
    private static final long serialVersionUID = 6427478923180132653L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "questionid")
    private Long id;
    /**
     * 题型
     */
    @Column(nullable = false, name = "questiontype")
    public Integer type = 1;
    /**
     * 题干
     */
    @Column(nullable = false, name = "question")
    public String question;
    /**
     * 选项
     */
    @Column(nullable = false, name = "questionselect")
    public String option;
    /**
     * 答案
     */
    @Column(nullable = false, name = "questionanswer")
    public String answer;
    /**
     * 解析
     */
    @Column(nullable = false, name = "questiondescribe")
    public String analysis;
    /**
     * 知识点ID
     */
    @Column(nullable = false, name = "questionknowsid")
    public Long zsdId;
    /**
     * 启用状态 0未启用、1已启用
     */
    @Column(nullable = false, name = "stzt")
    public Integer enable;
    /**
     * 难度
     */
    @Column(nullable = false, name = "stnd")
    public Float difficult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Long getZsdId() {
        return zsdId;
    }

    public void setZsdId(Long zsdId) {
        this.zsdId = zsdId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Float getDifficult() {
        return difficult;
    }

    public void setDifficult(Float difficult) {
        this.difficult = difficult;
    }
}
