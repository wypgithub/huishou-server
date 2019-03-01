package com.huishou.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p/>
 * <li>Description:学段类</li>
 * <li>@author: wyp </li>
 * <li>Date: 2018/7/1  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "cs_xdinfo")
public class XueDuan implements Serializable {
    private static final long serialVersionUID = 3598740365566135728L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "xdid")
    private Long id;
    /**
     * 名称
     */
    @Column(nullable = false, name = "xdmc")
    public String name;
    /**
     * 是否开启：0未开启 1已开启
     */
    @Column(nullable = false, name = "sfkq")
    public Integer enable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
