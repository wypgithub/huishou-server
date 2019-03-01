package com.huishou.service;

import com.huishou.constant.Constant;
import com.huishou.entity.User;
import com.huishou.repository.UserRepository;
import com.huishou.util.Sha1EncryptUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p/>
 * <li>Description:</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(User user,HttpServletRequest request) {
        User dbUser = userRepository.findByUserName(user.getUserName());
        if(dbUser == null){
            return Constant.USER_NAME_NOT_EXIST;
        }
        if(Sha1EncryptUtil.encrypt(user.getPassword()).equals(dbUser.getPassword())){
            //登陆成功缓存用户账号
            request.getSession().setAttribute(Constant.CURRENT_LOGIN_USER,dbUser);
            return Constant.RESULT_SUCCESS;
        }

        return Constant.RESULT_FAIL;
    }

    @Override
    public String registered(User user) {
        if(user == null || StringUtils.isEmpty(user.getUserName())
                || StringUtils.isEmpty(user.getPassword())
                || StringUtils.isEmpty(user.getAddress())){
            return Constant.RESULT_FAIL;
        }
        //新注册为普通用户
        user.setPassword(Sha1EncryptUtil.encrypt(user.getPassword()));
        user.setRegisteredDate(LocalDateTime.now());
        user.setType(Constant.USER_TYPE_ORD);
        userRepository.save(user);
        return Constant.RESULT_SUCCESS;
    }

    @Override
    public User checkMiBao(User user) {
        return userRepository.findByUserNameAndMiBao(user.getUserName(),user.getMiBao());
    }

    @Override
    public User findAllById(Long id) {
        return userRepository.findAllById(id);
    }

    @Override
    public User updateBalance(Long userId, double balance) {
        User user = userRepository.findAllById(userId);
        user.setBalance(user.getBalance() + balance);
        userRepository.save(user);
        return null;
    }
}
