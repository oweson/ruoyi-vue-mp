package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 高校管理对象 school
 *
 * @author oweson
 * @date 2022-03-15
 */
@Data
@Accessors(chain = true)
@TableName("school")
public class School extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 学校编号
     */
    private String schoolId;
    /**
     * 名字
     */
    private String schoolName;
    /**
     * 省份id
     */
    private String provinceId;
    /**
     * 省份
     */
    private String provinceName;
    /**
     * 城市id
     */
    private String cityId;
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 高校级别
     */
    private String level;
    /**
     * 高校所属
     */
    private String department;
    /**
     * 其他
     */
    private String other;

}
