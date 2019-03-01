package com.huishou.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p/>
 * <li>Description:做题表</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_hyztlog")
public class Answer implements Serializable {
    private static final long serialVersionUID = -2360985795185104782L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ztxh")
    private Long id;
    /**
     * 用户ID
     */
    @Column(nullable = false, name = "hyxh")
    private Long userId;
    /**
     * 试题ID
     */
    @Column(nullable = false, name = "stxh")
    private Long stId;
    /**
     * 开始答题时间
     **/
    @Column(nullable = false, name = "kssj")
    private LocalDate startTime;
    /**
     * 答题时长
     **/
    @Column(nullable = false, name = "ztsc")
    private Double answerTime;
    /**
     * 答题答案
     **/
    @Column(nullable = false, name = "xsda")
    private String answer;
    /**
     * 是否正确 0错误 1正确
     **/
    @Column(nullable = false, name = "sfzq")
    private Integer judgment;
    /**
     * 满分
     **/
    @Column(nullable = true, name = "stfs")
    private Integer fullScore;
    /**
     * 得分
     **/
    @Column(nullable = true, name = "xsdf")
    private Double score;
    /**
     * 实体类型 0练习 1作业
     **/
    @Column(nullable = false, name = "ztlx")
    private Integer type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStId() {
        return stId;
    }

    public void setStId(Long stId) {
        this.stId = stId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public Double getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Double answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getJudgment() {
        return judgment;
    }

    public void setJudgment(Integer judgment) {
        this.judgment = judgment;
    }

    public Integer getFullScore() {
        return fullScore;
    }

    public void setFullScore(Integer fullScore) {
        this.fullScore = fullScore;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
