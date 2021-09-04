package com.ruoyi.service;
import java.util.Date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.mapper.App;
import com.ruoyi.system.domain.Card;
import com.ruoyi.system.service.ICardService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author oweson
 * @date 2021/5/4 22:32
 */


public class CardServiceTest extends App {

    @Autowired
    ICardService iCardServiceImpl;

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
