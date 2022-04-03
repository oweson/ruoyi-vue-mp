package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * app记录对象 app_write
 *
 * @author oweson
 * @date 2022-03-24
 */
@Data
@Accessors(chain = true)
@TableName("app_write")
public class AppWrite extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 名字
     */
    private String appName;
    /**
     * 类型
     */
    private String appType;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 评论
     */
    private String remark;
    /**
     * 用户id
     */
    private Long userId;

}
