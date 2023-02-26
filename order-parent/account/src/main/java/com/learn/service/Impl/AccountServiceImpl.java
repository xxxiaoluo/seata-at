package com.learn.service.Impl;

import com.learn.mapper.AccountMapper;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public void decrease(Long userId, BigDecimal money) {

        if(Math.random() < 0.6){
            throw new RuntimeException("账户异常!");
        }
        accountMapper.decrease(userId, money);
    }
}
