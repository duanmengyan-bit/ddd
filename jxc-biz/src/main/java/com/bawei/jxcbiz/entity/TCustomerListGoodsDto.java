package com.bawei.jxcbiz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class TCustomerListGoodsDto {

    List<TCustomerReturnListGoods> salelist;

    private Integer id;

    private Float amountPaid;

    private Float amountPayable;

    private String remarks;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date customerReturnDate;

    private String customerReturnNumber;

    private Integer state;

    private Integer userId;

    private Integer customerId;
}
