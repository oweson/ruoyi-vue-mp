package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Card;
import com.ruoyi.system.mapper.CardMapper;
import com.ruoyi.system.service.ICardService;
import org.springframework.stereotype.Service;

/**
 * @author oweson
 * @date 2021/5/4 22:25
 */

@Service
public class ICardServiceImpl extends ServiceImpl<CardMapper, Card> implements ICardService {
	@Override
	public QueryWrapper<Card> getWrappers(Card card){
		QueryWrapper<Card> wrapper = new QueryWrapper<>();
		if (StringUtils.isNotEmpty(card.getCode())) {
			wrapper.eq("code",card.getCode());
		}
		if(StringUtils.isNotEmpty(card.getRemark())){
			wrapper.like("remark",card.getRemark());
		}
		return wrapper;
	}
}
