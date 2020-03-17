package com.bawei.jxccommon.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TSaleListDto extends Page{
    private Integer id;

    private Float amountPaid;

    private Float amountPayable;

    private String remarks;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;


    private String startTime;
    private String endTime;

    private String saleNumber;

    private Integer state;

    private Integer userId;

    private Integer customerId;

    private String name;

    private String true_name;
}
