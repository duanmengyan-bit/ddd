package com.bawei.jxccommon.Dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
public class GoodTypeDto {
    private int value;

    private String label;

  // @JsonSerialize(include = JsonSerialize.Inclusion.DEFAULT_INCLUSION.NON_NULL)
    private List<GoodTypeDto> children;
}
