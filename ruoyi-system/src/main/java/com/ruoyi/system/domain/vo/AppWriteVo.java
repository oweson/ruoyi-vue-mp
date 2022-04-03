package com.ruoyi.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * app记录视图对象 app_write
 *
 * @author oweson
 * @date 2022-03-24
 */
@Data
@ApiModel("app记录视图对象")
@ExcelIgnoreUnannotated
public class AppWriteVo {

	private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@ExcelProperty(value = "主键")
	@ApiModelProperty("主键")
	private Long id;

    /**
     * 名字
     */
	@ExcelProperty(value = "名字")
	@ApiModelProperty("名字")
	private String appName;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "app_type_record")
	@ApiModelProperty("类型")
	private String appType;

    /**
     * 简介
     */
	@ExcelProperty(value = "简介")
	@ApiModelProperty("简介")
	private String introduction;

    /**
     * 评论
     */
	@ExcelProperty(value = "评论")
	@ApiModelProperty("评论")
	private String remark;

    /**
     * 创建时间
     */
	@ExcelProperty(value = "创建时间")
	@ApiModelProperty("创建时间")
	private Date createTime;

    /**
     * 更新时间
     */
	@ExcelProperty(value = "更新时间")
	@ApiModelProperty("更新时间")
	private Date updateTime;

    /**
     * 用户id
     */
	@ExcelProperty(value = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;


}
