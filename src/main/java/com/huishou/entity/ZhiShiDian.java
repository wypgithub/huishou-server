package com.huishou.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p/>
 * <li>Description:知识点</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "cs_zsdinfo")
public class ZhiShiDian implements Serializable {
    private static final long serialVersionUID = -7907989788451134575L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "zsdxh")
    private Long id;
    /**
     * 名称
     */
    @Column(nullable = false, name = "zsdmc")
    public String name;
    /**
     * 章节ID
     */
    @Column(nullable = false, name = "ylzj")
    public Long zjId;

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

    public Long getZjId() {
        return zjId;
    }

    public void setZjId(Long zjId) {
        this.zjId = zjId;
    }
}
