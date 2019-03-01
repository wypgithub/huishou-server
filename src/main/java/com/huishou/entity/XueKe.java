package com.huishou.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p/>
 * <li>Description:学科</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "cs_xkinfo")
public class XueKe implements Serializable {
    private static final long serialVersionUID = -6117349555008064370L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "xkid")
    private Long id;
    /**
     * 名称
     */
    @Column(nullable = false, name = "xknr")
    public String name;
    /**
     * 图标
     */
    @Column(nullable = true, name = "image")
    public String image;
    /**
     * 学段ID
     */
    @Column(nullable = false, name = "xdid")
    public Long xdId;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getXdId() {
        return xdId;
    }

    public void setXdId(Long xdId) {
        this.xdId = xdId;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
