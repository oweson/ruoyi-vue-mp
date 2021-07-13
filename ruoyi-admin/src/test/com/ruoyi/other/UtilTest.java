package com.ruoyi.other;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.ruoyi.common.utils.file.FileUtils;

/**
 * @author oweson
 * @date 2021/6/27 15:59
 */


public class UtilTest {
	public static void main(String[] args) {
		DateUtil.date();
		String normDatetimeMinutePattern = DatePattern.NORM_DATETIME_MINUTE_PATTERN;
		System.out.println(normDatetimeMinutePattern);
	}
}
