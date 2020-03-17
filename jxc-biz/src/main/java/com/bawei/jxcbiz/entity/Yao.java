package com.bawei.jxcbiz.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 段梦燕
 * @since 2020-03-16
 */
@Data
@Accessors(chain = true)
public class Yao extends Model<Yao> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer ku;

    private Integer price;

    private Integer liang;

    private String fang;

    private String ci;

    private String ji;

    private int sum;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
