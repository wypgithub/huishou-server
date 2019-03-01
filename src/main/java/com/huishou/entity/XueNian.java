package com.huishou.entity;

/**
 * <p/>
 * <li>Description:</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cs_xninfo ")
public class XueNian implements Serializable {
    private static final long serialVersionUID = -4090582194095903186L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "xnid")
    private Long id;
    /**
     * 名称
     */
    @Column(nullable = false, name = "xnnr")
    public String name;
    /**
     * 学科ID
     */
    @Column(nullable = false, name = "xkid")
    public Long xkId;
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

    public Long getXkId() {
        return xkId;
    }

    public void setXkId(Long xkId) {
        this.xkId = xkId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
