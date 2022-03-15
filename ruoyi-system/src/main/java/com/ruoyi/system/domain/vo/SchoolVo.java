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
 * 高校管理视图对象 school
 *
 * @author oweson
 * @date 2022-03-15
 */
@Data
@ApiModel("高校管理视图对象")
@ExcelIgnoreUnannotated
public class SchoolVo {

	private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@ExcelProperty(value = "主键")
	@ApiModelProperty("主键")
	private Long id;

    /**
     * 学校编号
     */
	@ExcelProperty(value = "学校编号")
	@ApiModelProperty("学校编号")
	private String schoolId;

    /**
     * 名字
     */
	@ExcelProperty(value = "名字")
	@ApiModelProperty("名字")
	private String schoolName;

    /**
     * 省份id
     */
	@ExcelProperty(value = "省份id")
	@ApiModelProperty("省份id")
	private String provinceId;

    /**
     * 省份
     */
	@ExcelProperty(value = "省份")
	@ApiModelProperty("省份")
	private String provinceName;

    /**
     * 城市id
     */
	@ExcelProperty(value = "城市id")
	@ApiModelProperty("城市id")
	private String cityId;

    /**
     * 城市名
     */
	@ExcelProperty(value = "城市名")
	@ApiModelProperty("城市名")
	private String cityName;

    /**
     * 高校级别
     */
	@ExcelProperty(value = "高校级别")
	@ApiModelProperty("高校级别")
	private String level;

    /**
     * 高校所属
     */
	@ExcelProperty(value = "高校所属")
	@ApiModelProperty("高校所属")
	private String department;

    /**
     * 其他
     */
	@ExcelProperty(value = "其他")
	@ApiModelProperty("其他")
	private String other;


}
