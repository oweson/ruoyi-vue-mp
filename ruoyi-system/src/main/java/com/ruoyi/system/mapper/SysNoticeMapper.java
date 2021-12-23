package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.mybatisplus.core.BaseMapperPlus;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.dto.SysNoticeDTO;
import com.ruoyi.system.request.NoticeRequestParam;
import org.apache.ibatis.annotations.Param;

/**
 * 通知公告表 数据层
 *
 * @author Lion Li
 */
public interface SysNoticeMapper extends BaseMapperPlus<SysNotice> {
	Page<SysNoticeDTO> getNoticePage(IPage<SysNoticeDTO> page, @Param(Constants.WRAPPER) QueryWrapper<SysNoticeDTO> wrapper);


}
