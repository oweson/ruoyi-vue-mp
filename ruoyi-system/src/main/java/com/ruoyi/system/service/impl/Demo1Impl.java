package com.ruoyi.system.service.impl;

import com.ruoyi.system.service.Demo1;
import org.springframework.stereotype.Service;

/**
 * @author oweson
 * @date 2021/10/16 10:14
 */

@Service("kill")
public class Demo1Impl implements Demo1 {
    @Override
    public void say() {
        System.out.println("haha!");
    }
}
