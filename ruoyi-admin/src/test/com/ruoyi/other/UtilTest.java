package com.ruoyi.other;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.google.common.base.Joiner;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author oweson
 * @date 2021/6/27 15:59
 */


public class UtilTest {
	public static void main(String[] args) throws InterruptedException {
		List emptyList = Collections.EMPTY_LIST;

		ArrayList<Object> objects = Lists.newArrayList();
		/*Object o = new Object();
		o.wait();
		o.notify();*/
		DateUtil.date();
		String normDatetimeMinutePattern = DatePattern.NORM_DATETIME_MINUTE_PATTERN;
		System.out.println(normDatetimeMinutePattern);

		//             return Result.fail(String.format("找不到销售合同编号为:【%s】的信息", Joiner.on(",").join(queryParam.getCodeSet())));
        String format = String.format("找不到数据为【%s】的信息", Joiner.on(",").join(com.google.common.collect.Lists.newArrayList(1, 2, 3)));
        System.out.println(format);

    }
}
