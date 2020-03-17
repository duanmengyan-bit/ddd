package com.bawei.jxccommon.Dto;

import lombok.Data;

import java.util.List;

@Data
public class NationDto {

    private int value;
    private String label;
    private List<NationDto> children;
}
