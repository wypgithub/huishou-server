package com.huishou.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p/>
 * <li>Description:收藏</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_hystsc")
public class Collection implements Serializable {
    private static final long serialVersionUID = 1807130370173644882L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "scxh")
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
     * 类型:1.普通收藏 2.错题本收藏
     */
    @Column(nullable = false, name = "type")
    private Integer type;

    /**
     * 收藏时间
     */
    @Column(nullable = false, name = "scsj")
    private LocalDateTime collectionTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalDateTime collectionTime) {
        this.collectionTime = collectionTime;
    }
}
