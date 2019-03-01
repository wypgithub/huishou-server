package com.huishou.entity;

import javax.persistence.*;
import java.util.List;

/**
 * <p/>
 * <li>Description:测评题目</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_cptmxx")
public class EvalTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "tmxh")
    private Long id;
    /**
     * 测评信息ID
     */
    @Column(nullable = false,name = "cpxh")
    private Long informationId;
    /**
     * 题目内容
     */
    @Column(nullable = false,length = 150,name = "tmnr")
    private String content;
    /**
     * 选项
     */
    @Transient
    private List<EvalTopicOption> option;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<EvalTopicOption> getOption() {
        return option;
    }

    public void setOption(List<EvalTopicOption> option) {
        this.option = option;
    }
}
