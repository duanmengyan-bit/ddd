package com.bawei.jxcbiz.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class Tsalelistuser {
    List<TSaleListGoods> salelist;

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


}