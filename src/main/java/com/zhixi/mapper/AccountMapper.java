package com.zhixi.mapper;

import com.zhixi.pojo.Account;
import org.springframework.stereotype.Repository;

/**
 * @author zhixi
 * @description 针对表【account】的数据库操作Mapper
 * @createDate 2022-11-27 15:02:44
 * @Entity com.zhixi.pojo.Account
 */
@Repository
public interface AccountMapper {
    /**
     * 插入
     *
     * @param record 账户实体
     * @return =1表示插入成功
     */
    int insertSelective(Account record);

    /**
     * 根据id删除账户
     *
     * @param id id
     * @return =1表示删除成功
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据账户名称删除账户
     *
     * @param accountName 账户名称
     * @return =1表示删除成功
     */
    int deleteByAccountName(String accountName);

    /**
     * 更新账户
     *
     * @param record 账户实体
     * @return =1表示更新成功
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * 根据id查询账户
     *
     * @param id id
     * @return 账户实体
     */
    Account selectByPrimaryKey(Long id);

    /**
     * 根据账户名称查询账户
     *
     * @param accountName 账户id
     * @return 账户实体
     */
    Account selectByAccountName(String accountName);


}
