package com.ruoyi.web.controller.study;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.vo.SchoolVo;
import com.ruoyi.system.domain.bo.SchoolBo;
import com.ruoyi.system.service.ISchoolService;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;

/**
 * 高校管理Controller
 *
 * @author oweson
 * @date 2022-03-15
 */
@Validated
@Api(value = "高校管理控制器", tags = {"高校管理管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/school")
public class SchoolController extends BaseController {

    private final ISchoolService iSchoolService;

    /**
     * 查询高校管理列表
     */
    @ApiOperation("查询高校管理列表")
    @PreAuthorize("@ss.hasPermi('system:school:list')")
    @GetMapping("/list")
    public TableDataInfo<SchoolVo> list(@Validated(QueryGroup.class) SchoolBo bo, PageQuery pageQuery) {
        return iSchoolService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出高校管理列表
     */
    @ApiOperation("导出高校管理列表")
    @PreAuthorize("@ss.hasPermi('system:school:export')")
    @Log(title = "高校管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(@Validated SchoolBo bo, HttpServletResponse response) {
        List<SchoolVo> list = iSchoolService.queryList(bo);
        ExcelUtil.exportExcel(list, "高校管理", SchoolVo.class, response);
    }

    /**
     * 获取高校管理详细信息
     */
    @ApiOperation("获取高校管理详细信息")
    @PreAuthorize("@ss.hasPermi('system:school:query')")
    @GetMapping("/{id}")
    public AjaxResult<SchoolVo> getInfo(@ApiParam("主键")
                                                  @NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iSchoolService.queryById(id));
    }

    /**
     * 新增高校管理
     */
    @ApiOperation("新增高校管理")
    @PreAuthorize("@ss.hasPermi('system:school:add')")
    @Log(title = "高校管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public AjaxResult<Void> add(@Validated(AddGroup.class) @RequestBody SchoolBo bo) {
        return toAjax(iSchoolService.insertByBo(bo) ? 1 : 0);
    }

    /**
     * 修改高校管理
     */
    @ApiOperation("修改高校管理")
    @PreAuthorize("@ss.hasPermi('system:school:edit')")
    @Log(title = "高校管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public AjaxResult<Void> edit(@Validated(EditGroup.class) @RequestBody SchoolBo bo) {
        return toAjax(iSchoolService.updateByBo(bo) ? 1 : 0);
    }

    /**
     * 删除高校管理
     */
    @ApiOperation("删除高校管理")
    @PreAuthorize("@ss.hasPermi('system:school:remove')")
    @Log(title = "高校管理" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@ApiParam("主键串")
                                       @NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iSchoolService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
