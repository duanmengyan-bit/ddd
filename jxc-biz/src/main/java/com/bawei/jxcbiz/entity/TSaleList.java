package com.bawei.jxcbiz.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName(value = "t_sale_list",resultMap = "BaseResultMap")
public class TSaleList extends Model<TSaleList> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Float amountPaid;

    private Float amountPayable;

    private String remarks;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;


    private String saleNumber;

    private Integer state;

    private Integer userId;

    private Integer customerId;




    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
