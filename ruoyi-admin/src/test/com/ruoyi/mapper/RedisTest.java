package com.ruoyi.mapper;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author oweson
 * @date 2021/8/29 9:53
 */


public class RedisTest extends App {
	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void lockTest() {
		RedissonClient redissonClient = Redisson.create();
		RLock hello = redissonClient.getLock("hello");
		hello.lock(10, TimeUnit.MINUTES);
		hello.unlock();
	}

	public static void main(String[] args) {

	}
}
