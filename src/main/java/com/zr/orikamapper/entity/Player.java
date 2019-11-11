package com.zr.orikamapper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("运动员")
public class Player {
    @ApiModelProperty(value = "姓名", example = "")
    private String name;
}
