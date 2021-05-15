package com.ruoyi.system.domain;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author oweson
 * @date 2021/5/4 22:00
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("public_card")
public class Card implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @NotBlank(message = "身份证不能为空")
    @Size(min = 0, max = 50, message = "身份证不能超过50个字符")
    private String code;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    @TableField(exist = false)
    private String remark;
}
