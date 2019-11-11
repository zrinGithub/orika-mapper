package com.zr.orikamapper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("价格显示")
public class Price {
    @ApiModelProperty(value = "显示价格", example = "")
    private String showPrice;
}
