package com.ruoyi.service;
import java.util.Date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.utils.RedisUtils;
import com.ruoyi.mapper.App;
import com.ruoyi.system.domain.Card;
import com.ruoyi.system.service.Demo1;
import com.ruoyi.system.service.ICardService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;

import java.util.List;
import java.util.UUID;

/**
 * @author oweson
 * @date 2021/5/4 22:32
 */


public class CardServiceTest extends App {

    @Autowired
    ICardService iCardServiceImpl;

    @Autowired
    Demo1 demo1;



    @Test
    public void  test1(){
        demo1.say();

    }




    @Test
    public void redisKeyTest(){
        for (int i = 0; i <1000000 ; i++) {
            String s = UUID.randomUUID().toString();
            RedisUtils.setCacheObject(s,s);


        }
    }

    @Test
    public void select() {
        Card byId = iCardServiceImpl.getById(1);
        System.out.println(byId);
    }

    @Test
    public void wrapperTest() {
        LambdaQueryWrapper<Card> cardLambdaQueryWrapper = new LambdaQueryWrapper<>();
        QueryWrapper<Card> cardQueryWrapper = new QueryWrapper<>();
        cardQueryWrapper.and(wra->wra.eq("code", "123").or().eq("code", "789"));
        DateTime end = DateUtil.date();
       // DateTime begin = DateUtil.date().offset(DateField.DAY_OF_MONTH, -2);
        DateTime begin = end.offset(DateField.DAY_OF_MONTH, -2);
        cardQueryWrapper.between("create_time", begin, end);
        List<Card> list = iCardServiceImpl.list(cardQueryWrapper);
        System.out.println(list);
        // todo
    }
    @Test
	public void test2(){
		Card card = new Card();
		card.setCode("123");
		List<Card> list = iCardServiceImpl.list(iCardServiceImpl.getWrappers(card));
		System.out.println(list);
	}
}
