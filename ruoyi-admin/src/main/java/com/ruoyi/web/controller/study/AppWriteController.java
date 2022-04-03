package com.ruoyi.web.controller.study;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.bo.AppWriteBo;
import com.ruoyi.system.domain.vo.AppWriteVo;
import com.ruoyi.system.service.IAppWriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * app记录Controller
 *
 * @author oweson
 * @date 2022-03-24
 */
@Validated
@Api(value = "app记录控制器", tags = {"app记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/appWrite")
public class AppWriteController extends BaseController {

    private final IAppWriteService iAppWriteService;

    /**
     * 查询app记录列表
     */
    @ApiOperation("查询app记录列表")
    @PreAuthorize("@ss.hasPermi('system:appWrite:list')")
    @GetMapping("/list")
    public TableDataInfo<AppWriteVo> list(@Validated(QueryGroup.class) AppWriteBo bo, PageQuery pageQuery) {
        return iAppWriteService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出app记录列表
     */
    @ApiOperation("导出app记录列表")
    @PreAuthorize("@ss.hasPermi('system:appWrite:export')")
    @Log(title = "app记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(@Validated AppWriteBo bo, HttpServletResponse response) {
        List<AppWriteVo> list = iAppWriteService.queryList(bo);
        ExcelUtil.exportExcel(list, "app记录", AppWriteVo.class, response);
    }

    /**
     * 获取app记录详细信息
     */
    @ApiOperation("获取app记录详细信息")
    @PreAuthorize("@ss.hasPermi('system:appWrite:query')")
    @GetMapping("/{id}")
    public AjaxResult<AppWriteVo> getInfo(@ApiParam("主键")
                                                  @NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iAppWriteService.queryById(id));
    }

    /**
     * 新增app记录
     */
    @ApiOperation("新增app记录")
    @PreAuthorize("@ss.hasPermi('system:appWrite:add')")
    @Log(title = "app记录", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public AjaxResult<Void> add(@Validated(AddGroup.class) @RequestBody AppWriteBo bo) {
        return toAjax(iAppWriteService.insertByBo(bo) ? 1 : 0);
    }

    /**
     * 修改app记录
     */
    @ApiOperation("修改app记录")
    @PreAuthorize("@ss.hasPermi('system:appWrite:edit')")
    @Log(title = "app记录", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public AjaxResult<Void> edit(@Validated(EditGroup.class) @RequestBody AppWriteBo bo) {
        return toAjax(iAppWriteService.updateByBo(bo) ? 1 : 0);
    }

    /**
     * 删除app记录
     */
    @ApiOperation("删除app记录")
    @PreAuthorize("@ss.hasPermi('system:appWrite:remove')")
    @Log(title = "app记录" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@ApiParam("主键串")
                                       @NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iAppWriteService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
