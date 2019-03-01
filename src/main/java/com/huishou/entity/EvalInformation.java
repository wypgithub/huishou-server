package com.huishou.entity;


import javax.persistence.*;

/**
 * <p/>
 * <li>Description:测评信息</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_cpxx")
public class EvalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "cpxh")
    private Long id;
    /**
     * 类别ID
     */
    @Column(nullable = false,name = "sslb")
    private Long categoryId;
    /**
     * 名称
     */
    @Column(nullable = false,length = 150,name = "cpbt")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
