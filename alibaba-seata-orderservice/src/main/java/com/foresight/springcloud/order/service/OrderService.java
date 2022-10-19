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
package com.foresight.springcloud.order.service;

import com.foresight.springcloud.order.entity.Order;
import com.foresight.springcloud.order.feign.AccountFeignClient;
import com.foresight.springcloud.order.feign.StockFeignClient;
import com.foresight.springcloud.order.repository.OrderDAO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Resource
    private AccountFeignClient accountFeignClient;
    @Resource
    private StockFeignClient stockFeignClient;
    @Resource
    private OrderDAO orderDAO;

    /**
     * 下单：创建订单、减库存、减账户金额，涉及到两个服务
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order().setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(
            orderMoney);
        orderDAO.insert(order);
        stockFeignClient.deduct(commodityCode, count);
        accountFeignClient.reduce(userId, orderMoney);

    }

    @Transactional(rollbackFor = Exception.class)
    public void create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order().setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(
            orderMoney);
        orderDAO.insert(order);

        accountFeignClient.reduce(userId, orderMoney);

    }

}
