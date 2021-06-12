package com.ruoyi.mapper;

import com.google.common.hash.Funnels;
import com.ruoyi.common.config.BloomFilterHelper;
import com.ruoyi.common.config.RedisBloomFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;

/**
 * @author oweson
 * @date 2021/6/12 21:50
 */


public class BooloanTest extends App {
	private static BloomFilterHelper<CharSequence> bloomFilterHelper;

	@Autowired
	private RedisBloomFilter redisBloomFilter;

	@PostConstruct
	public void init() {
		bloomFilterHelper = new BloomFilterHelper<CharSequence>(Funnels.stringFunnel(Charset.defaultCharset()), 100000, 0.01);
	}

	@Test
	public void run() throws Exception {
		for (int i = 0; i < 100; i++) {
			redisBloomFilter.addByBloomFilter(bloomFilterHelper, "bloom", i + "");
		}
		int j = 0;
		for (int i = 0; i < 1000; i++) {
			boolean result = redisBloomFilter.includeByBloomFilter(bloomFilterHelper, "bloom", i + "");
			if (!result) {
				j++;
			}
		}
		System.out.println("漏掉了" + j + "个");
	}

}
