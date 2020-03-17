package com.bawei.jxccommon.Dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TCustomerReturnListDto extends Page {

    private Integer id;

    private Float amountPaid;

    private Float amountPayable;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date customerReturnDate;

    private String customerReturnNumber;

    private String remarks;

    private Integer state;

    private Integer userId;

    private Integer customerId;
    private String startTime;
    private String endTime;

    private String name;

    private String true_name;

}
