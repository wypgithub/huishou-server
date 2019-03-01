package com.huishou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p/>
 * <li>Description:用户实体</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Entity
@Table(name = "yw_hyxx")
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6491431625067364224L;
    /**
     * 用户名
     */
    @Column(nullable = false, name = "user_name")
    public String userName;
    /**
     * 用户密码
     */
    @Column(nullable = false, name = "password")
    public String password;
    /**
     * 密保
     */
    @Column(nullable = false, name = "mi_bao")
    public String miBao;
    /**
     * 所在学校
     */
    @Column(nullable = false, name = "school")
    public String school;
    /**
     * 注册时间
     */
    @Column(nullable = false, name = "registered_date")
    public LocalDateTime registeredDate;
    /**
     * 积分,初始为0
     */
    @Column(name = "integral")
    public Double integral = 0D;
    /**
     * 余额,初始为0
     */
    @Column(name = "balance")
    public Double balance=0D;
    /**
     * 类别：0-普通 1-VIP
     */
    @Column(name = "type")
    public Integer type = 0;
    /**
     * VIP期限
     */
    @Column(nullable = true, name = "vip_term")
    public LocalDateTime vipTerm;
    /**
     * 地址
     */
    @Column(nullable = false, name = "address")
    public String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMiBao() {
        return miBao;
    }

    public void setMiBao(String miBao) {
        this.miBao = miBao;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LocalDateTime getVipTerm() {
        return vipTerm;
    }

    public void setVipTerm(LocalDateTime vipTerm) {
        this.vipTerm = vipTerm;
    }
}
