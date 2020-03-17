package com.bawei.jxcbiz.entity;

import com.baomidou.mybatisplus.annotations.TableName;
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
 * @author Mht
 * @since 2020-02-20
 */
@Data
@Accessors(chain = true)
@TableName(value = "t_customer",resultMap = "BaseResultMap")
public class TCustomer extends Model<TCustomer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String address;

    private String contact;

    private String name;

    private String number;

    private String remarks;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
