package com.ruoyi.ygptmp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author oweson
 * @date 2021/8/29 16:57
 */


public class Demo1Test {
	public static void main(String[] args) {
		ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);
		String collect = integers.stream().map(x -> x.toString()).collect(Collectors.joining(","));
		System.out.println(collect);
	}
}
