package com.ruoyi.mapper;
import java.util.Date;
import com.google.common.collect.Maps;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.mapper.SysNoticeMapper;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

/**
 * @author oweson
 * @date 2021/5/3 23:10
 */


public class SysNoticeMapperTest extends  App{
    @Autowired
    RedisCache redisCache;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    SysNoticeMapper sysNoticeMapper;
    @Test
    public void list(){
		QueryWrapper<SysNotice> sysNoticeQueryWrapper = new QueryWrapper<>();
		LambdaQueryWrapper<SysNotice> lambda = sysNoticeQueryWrapper.lambda();
		lambda.in(true,SysNotice::getNoticeId, Arrays.asList(1,2));
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeQueryWrapper);
        System.out.println(sysNotices);
    }
    @Test
    public void listWrapper(){
        SysNotice sysNotice = new SysNotice();
        sysNotice.setNoticeId(1L);
        QueryWrapper<SysNotice> sysNoticeQueryWrapper = new QueryWrapper<>();
        //sysNoticeQueryWrapper.eq(sysNotice.getNoticeId()!=null, "notice_id",sysNotice.getNoticeId());
        sysNoticeQueryWrapper.in("notice_id", Lists.newArrayList(1,2));
        sysNoticeQueryWrapper.like("notice_title","维护");
        List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeQueryWrapper);
        System.out.println(sysNotices);
    }

    @Test
    public void redisTest(){
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("owesonEye", "准备跑路", 10, TimeUnit.MINUTES);
        if(aBoolean){
            System.out.println("lock ok!");
        }
    }

	@Test
	public void listLambdaWrapper(){
		SysNotice sysNotice = new SysNotice();
		sysNotice.setNoticeId(1L);
		LambdaQueryWrapper<SysNotice> sysNoticeLambdaQueryWrapper = new LambdaQueryWrapper<>();
		sysNoticeLambdaQueryWrapper.eq(sysNotice.getNoticeId()!=null,SysNotice::getNoticeId,sysNotice.getNoticeId());
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeLambdaQueryWrapper);
		System.out.println(sysNotices);

	}

	@Test
	public void save(){
		SysNotice sysNotice = new SysNotice();
		//sysNotice.setNoticeId(3L);
		sysNotice.setNoticeTitle("跑路只是时间问题");
		sysNotice.setNoticeType("1");
		sysNotice.setNoticeContent("准备，时刻准备！");
		sysNotice.setStatus("1");
		sysNotice.setCreateBy("admin");
		sysNotice.setCreateTime(new Date());
		sysNotice.setUpdateBy("");
		sysNotice.setUpdateTime(new Date());
		sysNotice.setRemark("相信自己的感觉，何处有所栖？？？");
		sysNotice.setParams(Maps.newHashMap());
		int insert = sysNoticeMapper.insert(sysNotice);
		System.out.println(sysNotice);

	}
	@Test
	public void checkNotice(){
		QueryWrapper<SysNotice> sysNoticeQueryWrapper = new QueryWrapper<>();
		sysNoticeQueryWrapper.lambda().eq(SysNotice::getNoticeTitle,"跑路只是时间问题");
		sysNoticeQueryWrapper.lambda().ne(SysNotice::getNoticeId,1L);
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeQueryWrapper);
		System.out.println(sysNotices);
	}
}
