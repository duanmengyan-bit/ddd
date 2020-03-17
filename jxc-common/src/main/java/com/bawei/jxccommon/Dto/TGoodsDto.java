package com.bawei.jxccommon.Dto;

import lombok.Data;

@Data
public class TGoodsDto extends Page {

    private Integer id;

    private String code;

    private Integer inventoryQuantity;

    private Integer minNum;

    private String model;

    private String name;

    private String producer;

    private Float purchasingPrice;

    private String remarks;

    private Float sellingPrice;

    private String unit;

    private Integer typeId;

    private Integer state;

    private Float lastPurchasingPrice;



    private String bname;
    private Integer zongprice;
    private String jie;
}
