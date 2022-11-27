package com.zhixi.service.impl;

import com.zhixi.mapper.AccountMapper;
import com.zhixi.pojo.Account;
import com.zhixi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AccountServiceImpl
 * @Author zhangzhixi
 * @Description
 * @Date 2022-11-27 15:19
 * @Version 1.0
 */
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int insertSelective(Account record) {
        return accountMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return accountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByAccountName(String accountName) {
        return accountMapper.deleteByAccountName(accountName);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return accountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Account selectByPrimaryKey(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public Account selectByAccountName(String accountName) {
        return accountMapper.selectByAccountName(accountName);
    }
}
