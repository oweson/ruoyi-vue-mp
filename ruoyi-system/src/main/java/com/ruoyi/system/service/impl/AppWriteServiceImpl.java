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
import com.ruoyi.system.domain.bo.AppWriteBo;
import com.ruoyi.system.domain.vo.AppWriteVo;
import com.ruoyi.system.domain.AppWrite;
import com.ruoyi.system.mapper.AppWriteMapper;
import com.ruoyi.system.service.IAppWriteService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * app记录Service业务层处理
 *
 * @author oweson
 * @date 2022-03-24
 */
@Service
public class AppWriteServiceImpl extends ServicePlusImpl<AppWriteMapper, AppWrite, AppWriteVo> implements IAppWriteService {

    @Override
    public AppWriteVo queryById(Long id){
        return getVoById(id);
    }

    @Override
    public TableDataInfo<AppWriteVo> queryPageList(AppWriteBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<AppWrite> lqw = buildQueryWrapper(bo);
        Page<AppWriteVo> result = pageVo(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<AppWriteVo> queryList(AppWriteBo bo) {
        LambdaQueryWrapper<AppWrite> lqw = buildQueryWrapper(bo);
        return listVo(lqw);
    }

    private LambdaQueryWrapper<AppWrite> buildQueryWrapper(AppWriteBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<AppWrite> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getAppName()), AppWrite::getAppName, bo.getAppName());
        lqw.eq(StringUtils.isNotBlank(bo.getAppType()), AppWrite::getAppType, bo.getAppType());
        lqw.like(StringUtils.isNotBlank(bo.getIntroduction()), AppWrite::getIntroduction, bo.getIntroduction());
        lqw.like(StringUtils.isNotBlank(bo.getRemark()), AppWrite::getRemark, bo.getRemark());
        lqw.between(params.get("beginCreateTime") != null && params.get("endCreateTime") != null,
            AppWrite::getCreateTime ,params.get("beginCreateTime"), params.get("endCreateTime"));
        lqw.between(params.get("beginUpdateTime") != null && params.get("endUpdateTime") != null,
            AppWrite::getUpdateTime ,params.get("beginUpdateTime"), params.get("endUpdateTime"));
        return lqw;
    }

    @Override
    public Boolean insertByBo(AppWriteBo bo) {
        AppWrite add = BeanUtil.toBean(bo, AppWrite.class);
        validEntityBeforeSave(add);
        boolean flag = save(add);
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AppWriteBo bo) {
        AppWrite update = BeanUtil.toBean(bo, AppWrite.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(AppWrite entity){
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
