package com.huishou.entity;

import javax.persistence.*;

/**
 * <p/>
 * <li>Description:测评题目选项</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_cptmxxxx")
public class EvalTopicOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "xxxh")
    private Long id;
    /**
     * 测评题目ID
     */
    @Column(nullable = false,name = "tmxh")
    private Long topicId;
    /**
     * 选项内容
     */
    @Column(nullable = false,length = 150,name = "xxnr")
    private String content;
    /**
     * 分数
     */
    @Column(nullable = false,name = "xxfs")
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
