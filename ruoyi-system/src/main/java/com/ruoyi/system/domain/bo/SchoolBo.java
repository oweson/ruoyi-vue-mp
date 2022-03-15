package com.ruoyi.system.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 高校管理业务对象 school
 *
 * @author oweson
 * @date 2022-03-15
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("高校管理业务对象")
public class SchoolBo extends BaseEntity {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 学校编号
     */
    @ApiModelProperty(value = "学校编号", required = true)
    @NotBlank(message = "学校编号不能为空", groups = { AddGroup.class, EditGroup.class })
    private String schoolId;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字", required = true)
    @NotBlank(message = "名字不能为空", groups = { EditGroup.class })
    private String schoolName;

    /**
     * 省份id
     */
    @ApiModelProperty(value = "省份id", required = true)
    @NotBlank(message = "省份id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String provinceId;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份", required = true)
    @NotBlank(message = "省份不能为空", groups = { AddGroup.class, EditGroup.class })
    private String provinceName;

    /**
     * 城市id
     */
    @ApiModelProperty(value = "城市id", required = true)
    @NotBlank(message = "城市id不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cityId;

    /**
     * 城市名
     */
    @ApiModelProperty(value = "城市名", required = true)
    @NotBlank(message = "城市名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String cityName;

    /**
     * 高校级别
     */
    @ApiModelProperty(value = "高校级别", required = true)
    @NotBlank(message = "高校级别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String level;

    /**
     * 高校所属
     */
    @ApiModelProperty(value = "高校所属", required = true)
    @NotBlank(message = "高校所属不能为空", groups = { AddGroup.class, EditGroup.class })
    private String department;

    /**
     * 其他
     */
    @ApiModelProperty(value = "其他", required = true)
    @NotBlank(message = "其他不能为空", groups = { AddGroup.class, EditGroup.class })
    private String other;


}
