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
package com.foresight.springcloud.account.controller;

import com.foresight.springcloud.account.service.AccountService;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountServiceImpl;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    @RequestMapping("/reduce")
    Boolean reduce(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money)
    {
        accountServiceImpl.reduce(userId, money);
        return true;
    }
}