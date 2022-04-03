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
 * app记录业务对象 app_write
 *
 * @author oweson
 * @date 2022-03-24
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("app记录业务对象")
public class AppWriteBo extends BaseEntity {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字", required = true)
    @NotBlank(message = "名字不能为空", groups = { EditGroup.class })
    private String appName;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true)
    @NotBlank(message = "类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String appType;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介", required = true)
    @NotBlank(message = "简介不能为空", groups = { AddGroup.class, EditGroup.class })
    private String introduction;

    /**
     * 评论
     */
    @ApiModelProperty(value = "评论", required = true)
    @NotBlank(message = "评论不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}
