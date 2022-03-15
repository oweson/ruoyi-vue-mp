package com.ruoyi.system.service;

import com.ruoyi.system.domain.School;
import com.ruoyi.system.domain.vo.SchoolVo;
import com.ruoyi.system.domain.bo.SchoolBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 高校管理Service接口
 *
 * @author oweson
 * @date 2022-03-15
 */
public interface ISchoolService extends IServicePlus<School, SchoolVo> {
	/**
	 * 查询单个
	 * @return
	 */
	SchoolVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<SchoolVo> queryPageList(SchoolBo bo, PageQuery pageQuery);

	/**
	 * 查询列表
	 */
	List<SchoolVo> queryList(SchoolBo bo);

	/**
	 * 根据新增业务对象插入高校管理
	 * @param bo 高校管理新增业务对象
	 * @return
	 */
	Boolean insertByBo(SchoolBo bo);

	/**
	 * 根据编辑业务对象修改高校管理
	 * @param bo 高校管理编辑业务对象
	 * @return
	 */
	Boolean updateByBo(SchoolBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
