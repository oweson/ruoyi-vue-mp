package com.ruoyi.system.request;

import lombok.Data;

/**
 * @author oweson
 * @date 2021/8/19 21:44
 */

@Data
public class NoticeRequestParam {
	private String noticeTitle;

	/**
	 * 公告类型（1通知 2公告）
	 */
	private String noticeType;
}
