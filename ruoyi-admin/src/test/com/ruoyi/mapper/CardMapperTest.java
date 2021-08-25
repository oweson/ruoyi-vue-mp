package com.ruoyi.mapper;
import java.util.Date;

import com.ruoyi.common.tmp.UserDto;
import com.ruoyi.system.domain.Card;
import com.ruoyi.system.mapper.CardMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author oweson
 * @date 2021/5/4 22:12
 */


public class CardMapperTest extends  App {
    @Autowired
    CardMapper cardMapper;
    @Autowired
	ApplicationEventPublisher applicationEventPublisher;

    @Test
	public void eventTest(){
		UserDto userDto = new UserDto();
		userDto.setName("tom");
		userDto.setSex("1");

		applicationEventPublisher.publishEvent(userDto);
	}
    @Test
    public void insert(){
        Card card = new Card();
        card.setId(null);
        card.setCode("789");
        card.setCreateTime(new Date());
        //card.setUpdateTime(new Date());
        card.setRemark("");
        int insert = cardMapper.insert(card);
        System.out.println(card);

    }

    @Test
    public void update(){
        Card card = cardMapper.selectById(2);
        card.setCode("123456");
        cardMapper.updateById(card);
    }
}
