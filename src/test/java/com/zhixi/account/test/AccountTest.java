package com.zhixi.account.test;

import com.zhixi.pojo.Account;
import com.zhixi.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @ClassName AccountTest
 * @Author zhangzhixi
 * @Description
 * @Date 2022-11-27 15:30
 * @Version 1.0
 */
/*Spring对Junit的支持，可以在测试类中使用自动注入*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AccountTest {

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    /**
     * 根据账户主键ID查询
     */
    @Test
    public void testFindAccountById() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account account = accountService.selectByPrimaryKey(1L);
        System.out.println(account);
    }

    /**
     * 根据账户名称查询
     */
    @Test
    public void testFindAccountBuName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account accountName = accountService.selectByAccountName("acc_001");
        System.out.println(accountName);
    }

    /**
     * 插入账户
     */
    @Test
    public void testInsertSelective() {
        Account account = new Account();
        account.setAccountName("acc_004");
        account.setAccountBalance(new BigDecimal("40000"));
        int i = accountService.insertSelective(account);
        System.out.println(i == 1 ? "插入成功" : "插入失败");
        System.out.println("自动生成的ID是：" + account.getId());
    }

    /**
     * 更新账户信息
     */
    @Test
    public void testUpdateByPrimaryKeySelective() {
        Account account = accountService.selectByPrimaryKey(5L);
        account.setAccountName("acc_005");

        int i = accountService.updateByPrimaryKeySelective(account);
        System.out.println(i == 1 ? "更新成功" : "更新失败");
    }


}
