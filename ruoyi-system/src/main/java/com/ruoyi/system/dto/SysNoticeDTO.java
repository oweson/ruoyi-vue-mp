package com.ruoyi.system.dto;

import com.ruoyi.common.annotation.Query;
import lombok.Data;

/**
 * @author oweson
 * @date 2021/8/19 21:42
 */

@Data
public class SysNoticeDTO {
    @Query(type = Query.Type.EQUAL)
    private Long noticeId;
    @Query(type = Query.Type.INNER_LIKE)
    private String noticeTitle;
}
