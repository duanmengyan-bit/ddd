package com.bawei.jxccommon.Dto;

import lombok.Data;

import java.util.List;

@Data
public class YaoDto {

    List<YaoDto> salelist;

    private Integer id;

    private String name;

    private Integer ku;

    private Integer price;

    private Integer liang;

    private String fang;

    private String ci;

    private String ji;

}
