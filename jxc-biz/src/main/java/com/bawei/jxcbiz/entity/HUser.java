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
 * @author 段梦燕
 * @since 2020-03-16
 */
@Data
@Accessors(chain = true)
@TableName(value = "h_user")
public class HUser extends Model<HUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

   // private String birth;
    private String sex;

    private String phone;

    private String shen;

    private String jie;
    private int id1;
    private int id2;

    private String address;

    private String xiaddress;

    private String zhen;

    private String zhu;

    private Integer fei;

    private Integer yid;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
