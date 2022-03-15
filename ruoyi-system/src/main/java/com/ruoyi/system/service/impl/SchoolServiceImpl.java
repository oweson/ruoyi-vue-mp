package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.mybatisplus.core.ServicePlusImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.system.domain.bo.SchoolBo;
import com.ruoyi.system.domain.vo.SchoolVo;
import com.ruoyi.system.domain.School;
import com.ruoyi.system.mapper.SchoolMapper;
import com.ruoyi.system.service.ISchoolService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 高校管理Service业务层处理
 *
 * @author oweson
 * @date 2022-03-15
 */
@Service
public class SchoolServiceImpl extends ServicePlusImpl<SchoolMapper, School, SchoolVo> implements ISchoolService {

    @Override
    public SchoolVo queryById(Long id){
        return getVoById(id);
    }

    @Override
    public TableDataInfo<SchoolVo> queryPageList(SchoolBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<School> lqw = buildQueryWrapper(bo);
        Page<SchoolVo> result = pageVo(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<SchoolVo> queryList(SchoolBo bo) {
        LambdaQueryWrapper<School> lqw = buildQueryWrapper(bo);
        return listVo(lqw);
    }

    private LambdaQueryWrapper<School> buildQueryWrapper(SchoolBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<School> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getSchoolName()), School::getSchoolName, bo.getSchoolName());
        lqw.like(StringUtils.isNotBlank(bo.getProvinceName()), School::getProvinceName, bo.getProvinceName());
        lqw.like(StringUtils.isNotBlank(bo.getCityName()), School::getCityName, bo.getCityName());
        lqw.eq(StringUtils.isNotBlank(bo.getLevel()), School::getLevel, bo.getLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getDepartment()), School::getDepartment, bo.getDepartment());
        lqw.eq(StringUtils.isNotBlank(bo.getOther()), School::getOther, bo.getOther());
        return lqw;
    }

    @Override
    public Boolean insertByBo(SchoolBo bo) {
        School add = BeanUtil.toBean(bo, School.class);
        validEntityBeforeSave(add);
        boolean flag = save(add);
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(SchoolBo bo) {
        School update = BeanUtil.toBean(bo, School.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(School entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return removeByIds(ids);
    }
}
