package com.huishou.entity;

import javax.persistence.*;

/**
 * <p/>
 * <li>Description:测评类别</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_cplb")
public class EvalCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "lbxh")
    private Long id;
    /**
     * 名称
     */
    @Column(nullable = false,length = 50,name = "lbmc")
    private String name;
    /**
     * 价格
     */
    @Column(nullable = false,name = "price")
    private Double price = 0D;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
