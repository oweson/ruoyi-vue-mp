package com.ruoyi.common.config;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author oweson
 * @date 2021/6/12 21:49
 */

@Component
public class RedisBloomFilter<T> {
	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 根据给定的布隆过滤器添加值
	 */
	public <T> void addByBloomFilter(BloomFilterHelper<T> bloomFilterHelper, String key, T value) {
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<String>(String.class));
		Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
		int[] offset = bloomFilterHelper.murmurHashOffset(value);
		for (int i : offset) {
			//i代表的计算的hash值，同时也是数据的下标。
			//去bit数组中设置指定的hash值，
			redisTemplate.opsForValue().setBit(key, i, true);
//            cluster.setbit(key, i, true);
		}
	}

	/**
	 * 根据给定的布隆过滤器判断值是否存在
	 */
	public <T> boolean includeByBloomFilter(BloomFilterHelper<T> bloomFilterHelper, String key, T value) {
		Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
		int[] offset = bloomFilterHelper.murmurHashOffset(value);
		for (int i : offset) {
//            if (!cluster.getbit(key, i)) {
			if (!redisTemplate.opsForValue().getBit(key, i)) {
				return false;
			}
		}

		return true;
	}
}
