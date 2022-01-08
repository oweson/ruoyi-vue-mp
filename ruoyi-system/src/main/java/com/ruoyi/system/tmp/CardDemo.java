package com.ruoyi.system.tmp;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ruoyi.system.domain.Card;
import lombok.Data;

/**
 * @author oweson
 * @date 2022/1/6 23:23
 */

@Data
public class CardDemo extends Model<CardDemo> {

    private Integer id;

    public static void main(String[] args) {
        new CardDemo().deleteById();
    }
}
