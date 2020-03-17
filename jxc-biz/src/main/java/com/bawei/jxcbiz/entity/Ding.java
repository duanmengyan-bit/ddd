package com.bawei.jxcbiz.entity;

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
 * @since 2020-03-07
 */
@Data
@Accessors(chain = true)
public class Ding extends Model<Ding> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String orderNo;

    private Integer statu;

    private String subject;

    private String totalAmount;

    private String storeId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
