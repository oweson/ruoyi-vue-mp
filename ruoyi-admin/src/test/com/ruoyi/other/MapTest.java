package com.ruoyi.other;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.ruoyi.system.domain.Card;

/**
 * @author oweson
 * @date 2021/9/4 20:55
 */


public class MapTest {
	public static void main(String[] args) {
		Card card1 = new Card();
		card1.setId(0);
		card1.setCode("" + 0);
		card1.setCreateTime(new Date());
		card1.setUpdateTime(new Date());
		card1.setRemark("");
		ArrayList<Card> cards = Lists.newArrayList();
		cards.add(card1);
		for (int i = 0; i < 10; i++) {
			Card card = new Card();
			card.setId(i);
			card.setCode("" + i);
			card.setCreateTime(new Date());
			card.setUpdateTime(new Date());
			card.setRemark(""+i);
			cards.add(card);


		}
		Map<String, Card> stringCardMap = cards.stream().collect(Collectors.toMap(x -> x.getCode(), x -> x, (a, b) -> b));
		System.out.println(stringCardMap);
	}
}
