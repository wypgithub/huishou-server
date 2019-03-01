package com.huishou.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p/>
 * <li>Description:章节</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "cs_zjinfo")
public class ZhangJie implements Serializable {
    private static final long serialVersionUID = -8863730850643439399L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "zjid")
    private Long id;
    /**
     * 名称
     */
    @Column(nullable = false, name = "xknr")
    public String name;
    /**
     * 学年ID
     */
    @Column(nullable = false, name = "ylxn")
    public Long xnId;

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

    public Long getXnId() {
        return xnId;
    }

    public void setXnId(Long xnId) {
        this.xnId = xnId;
    }
}
