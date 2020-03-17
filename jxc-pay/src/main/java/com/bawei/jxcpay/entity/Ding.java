package com.bawei.jxcpay.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
