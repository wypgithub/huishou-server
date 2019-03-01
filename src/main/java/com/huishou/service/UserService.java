package com.huishou.service;

import com.huishou.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * <p/>
 * <li>Description:用户Service</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
public interface UserService {
    /**
     * 检查用户数是否存在
     * @param user 用户
     * @return 1-成功 2-失败 3-用户名不存在
     */
    String login(User user,HttpServletRequest request);
    /**
     * 保存更新用户
     * @param user 用户
     */
    String registered(User user);
    /**
     * 检查密保
     * @param user 用户
     */
    User checkMiBao(User user);
    /**
     * 根据ID查询
     * @param id 用户ID
     */
    User findAllById(Long id);
    /**
     * 更新用户余额
     * @param userId 用户ID
     * @param balance 余额
     * @return
     */
    User updateBalance(Long userId,double balance);


}
