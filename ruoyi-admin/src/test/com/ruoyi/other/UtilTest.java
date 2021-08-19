package com.ruoyi.other;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.utils.file.FileUtils;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;

/**
 * @author oweson
 * @date 2021/6/27 15:59
 */


public class UtilTest {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Object> objects = Lists.newArrayList();
		Object o = new Object();
		o.wait();
		o.notify();
		DateUtil.date();
		String normDatetimeMinutePattern = DatePattern.NORM_DATETIME_MINUTE_PATTERN;
		System.out.println(normDatetimeMinutePattern);

	}
}
