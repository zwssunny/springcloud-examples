/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.foresight.springcloud.account.service;

import com.foresight.springcloud.account.repository.AccountDao;

import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.foresight.springcloud.account.entity.Account;
import com.foresight.springcloud.account.feign.OrderFeignClient;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceImpl")
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private OrderFeignClient orderFeignClient;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reduce(String userId, BigDecimal money) {
        log.info("------->扣减账户开始account中");
        //模拟超时异常，全局事务回滚
            //    try {
            //        Thread.sleep(30*1000);
            //    } catch (InterruptedException e) {
            //        e.printStackTrace();
            //    }
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Account().setUserId(userId));
        Account account = accountDao.selectOne(wrapper);
        account.setMoney(account.getMoney().subtract(money));

        accountDao.updateById(account);

        log.info("------->扣减账户结束account中");

        //修改订单状态，此调用会导致调用成环
        // LOGGER.info("修改订单状态开始");
        // String mes = orderFeignClient.update(userId, money.multiply(new BigDecimal("0.09")), 0);
        // LOGGER.info("修改订单状态结束：{}", mes);
    }


}
