package com.ruoyi.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.dto.SysNoticeDTO;
import com.ruoyi.system.mapper.SysNoticeMapper;
import com.ruoyi.system.utils.QueryHelpPlus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author oweson
 * @date 2021/5/3 23:10
 */


public class SysNoticeMapperTest extends App {


	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Resource
	SysNoticeMapper sysNoticeMapper;


	@Test
    public void queryTest(){
        SysNoticeDTO sysNoticeDTO = new SysNoticeDTO();
        sysNoticeDTO.setNoticeId(1L);
        sysNoticeDTO.setNoticeTitle("若依新版本发布啦");
        QueryWrapper predicate = QueryHelpPlus.getPredicate(SysNotice.class, sysNoticeDTO);
        List selectList = sysNoticeMapper.selectList(predicate);
        System.out.println(selectList);
    }


	@Test
	public void wrapperpageTest() {
		Page<SysNoticeDTO> page = new Page<SysNoticeDTO>(0, 2);
		QueryWrapper<SysNoticeDTO> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("s.notice_type", 1);
		queryWrapper.like("s.notice_title", "时间");
		queryWrapper.eq("n.notice_title", "起风了");
		Page<SysNoticeDTO> noticePage = sysNoticeMapper.getNoticePage(page, queryWrapper);
		System.out.println(noticePage);
	}

	/**
	 * 1 lambda测试
	 */
	@Test
	public void list() {
		QueryWrapper<SysNotice> sysNoticeQueryWrapper = new QueryWrapper<>();
		LambdaQueryWrapper<SysNotice> lambda = sysNoticeQueryWrapper.lambda();
		lambda.in(true, SysNotice::getNoticeId, Arrays.asList(1, 2));
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeQueryWrapper);
		System.out.println(sysNotices);
	}

	/**
	 * 2 queryWrapper测试
	 */
	@Test
	public void listWrapper() {
		SysNotice sysNotice = new SysNotice();
		sysNotice.setNoticeId(1L);
		QueryWrapper<SysNotice> sysNoticeQueryWrapper = new QueryWrapper<>();
		//sysNoticeQueryWrapper.eq(sysNotice.getNoticeId()!=null, "notice_id",sysNotice.getNoticeId());
		sysNoticeQueryWrapper.in("notice_id", Lists.newArrayList(1, 2));
		sysNoticeQueryWrapper.like("notice_title", "维护")
            .select("notice_id","notice_title");
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeQueryWrapper);
		System.out.println(sysNotices);
	}


	/**
	 * 3 lambda原生的测试
	 */
	@Test
	public void listLambdaWrapper() {
		SysNotice sysNotice = new SysNotice();
		sysNotice.setNoticeId(1L);
		LambdaQueryWrapper<SysNotice> sysNoticeLambdaQueryWrapper = new LambdaQueryWrapper<>();
		sysNoticeLambdaQueryWrapper.eq(sysNotice.getNoticeId() != null, SysNotice::getNoticeId, sysNotice.getNoticeId());
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeLambdaQueryWrapper);
		System.out.println(sysNotices);

	}

	/**
	 * 4 保存测试
	 */
	@Test
	public void save() {
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

	/**
	 * 5 删除
	 */

	@Test
	public void deleteTest() {
		LambdaQueryWrapper<SysNotice> sysNoticeLambdaQueryWrapper = new LambdaQueryWrapper<>();
		sysNoticeLambdaQueryWrapper.eq(SysNotice::getNoticeTitle, "hi");
		sysNoticeMapper.delete(sysNoticeLambdaQueryWrapper);
		// 2 批量删除
		sysNoticeMapper.deleteBatchIds(Lists.newArrayList(asList(1, 2, 3)));

	}

	/**
	 * 6 右边模糊查询
	 */

	@Test
	public void likeTest() {
		LambdaQueryWrapper<SysNotice> sysNoticeLambdaQueryWrapper = new LambdaQueryWrapper<>();
		//温馨%
		sysNoticeLambdaQueryWrapper.likeRight(SysNotice::getNoticeTitle, "温馨");
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeLambdaQueryWrapper);
		System.out.println(sysNotices);
	}

	/**
	 * 7 查询必要的字段
	 */
	@Test
	public void selectNeedField() {
		QueryWrapper<SysNotice> noticeQueryWrapper = new QueryWrapper<>();
		noticeQueryWrapper.select("notice_type", "notice_title");
		noticeQueryWrapper.last("limit 1");
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(noticeQueryWrapper);
		System.out.println(sysNotices);
		Map<String, List<SysNotice>> stringListMap = sysNotices.stream().collect(Collectors.groupingBy(SysNotice::getNoticeType));
		System.out.println(stringListMap);
	}

	/**
	 * 8 其他的测试
	 */

	@Test
	public void otherTest() {
		//  queryWrapper.and(wrapper -> wrapper.and(wrapper1 -> wrapper1.eq(DwSubjectDataInfoWw::getYear, year1).ge(DwSubjectDataInfoWw::getWeek, week1))
		//                    .or(wrapper2 -> wrapper2.eq(DwSubjectDataInfoWw::getYear, year2).le(DwSubjectDataInfoWw::getWeek, week2)));
		//        }
		LambdaQueryWrapper<SysNotice> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.eq(SysNotice::getNoticeType, 100);
		lambdaQueryWrapper.or(item -> item.eq(SysNotice::getNoticeType, 2));
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(lambdaQueryWrapper);
		System.out.println(sysNotices);
	}

	@Test
	public void checkNotice() {
		QueryWrapper<SysNotice> sysNoticeQueryWrapper = new QueryWrapper<>();
		sysNoticeQueryWrapper.lambda().eq(SysNotice::getNoticeTitle, "跑路只是时间问题");
		sysNoticeQueryWrapper.lambda().ne(SysNotice::getNoticeId, 1L);
		List<SysNotice> sysNotices = sysNoticeMapper.selectList(sysNoticeQueryWrapper);
		System.out.println(sysNotices);
	}

	@Test
	public void redisTest() {
		Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("owesonEye", "准备跑路", 10, TimeUnit.MINUTES);
		if (aBoolean) {
			System.out.println("lock ok!");
		}
	}
}
