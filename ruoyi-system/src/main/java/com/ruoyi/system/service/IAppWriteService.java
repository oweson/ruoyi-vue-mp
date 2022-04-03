package com.ruoyi.system.service;

import com.ruoyi.system.domain.AppWrite;
import com.ruoyi.system.domain.vo.AppWriteVo;
import com.ruoyi.system.domain.bo.AppWriteBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * app记录Service接口
 *
 * @author oweson
 * @date 2022-03-24
 */
public interface IAppWriteService extends IServicePlus<AppWrite, AppWriteVo> {
	/**
	 * 查询单个
	 * @return
	 */
	AppWriteVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<AppWriteVo> queryPageList(AppWriteBo bo, PageQuery pageQuery);

	/**
	 * 查询列表
	 */
	List<AppWriteVo> queryList(AppWriteBo bo);

	/**
	 * 根据新增业务对象插入app记录
	 * @param bo app记录新增业务对象
	 * @return
	 */
	Boolean insertByBo(AppWriteBo bo);

	/**
	 * 根据编辑业务对象修改app记录
	 * @param bo app记录编辑业务对象
	 * @return
	 */
	Boolean updateByBo(AppWriteBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
