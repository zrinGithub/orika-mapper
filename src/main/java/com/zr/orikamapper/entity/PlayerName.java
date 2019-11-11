package com.zr.orikamapper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("运动员名称")
public class PlayerName {
    @ApiModelProperty(value = "名", example = "")
    private String firstName;
    @ApiModelProperty(value = "姓", example = "")
    private String lastName;
}
