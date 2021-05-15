package com.ruoyi.mapper;

import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysNoticeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author oweson
 * @date 2021/5/3 23:10
 */


public class SysNoticeMapperTest extends  App{

    @Autowired
    SysNoticeMapper sysNoticeMapper;
    @Test
    public void list(){
        List<SysNotice> sysNotices = sysNoticeMapper.selectList(null);
        System.out.println(sysNotices);
    }
}
