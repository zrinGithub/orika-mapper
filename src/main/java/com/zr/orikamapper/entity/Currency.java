package com.zr.orikamapper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@ApiModel("简单货币类（只支持人民币）")
public class Currency {

    @ApiModelProperty(value = "分", example = "1L")
    private Long cent;
    @ApiModelProperty(value = "元", example = "1.0")
    private Double yuan;
    @ApiModelProperty(value = "整数的元", example = "1")
    private Integer yuanInt;
    @ApiModelProperty("元的显示格式")
    private String yuanFmt;


    public Currency() {
    }

    public Currency(Long cent) {
        setCent(cent);
    }

    public void setCent(Long cent) {
        this.cent = cent;
        if (cent != null) {
            this.setYuan(cent / 100.0);
            this.setYuanInt((int) (cent / 100));
        }
    }

    public void setYuan(Double yuan) {
        this.yuan = yuan;
        if (yuan != null) {
            this.cent = (long) (yuan * 100);
        } else {
            this.cent = null;
        }
    }

    public void setYuanInt(Integer yuanInt) {
        this.yuanInt = yuanInt;
        if (yuanInt != null) {
            this.cent = (long) (yuanInt * 100);
        } else {
            this.cent = null;
        }
    }

    public String getYuanFmt() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        return decimalFormat.format(yuan);
    }

    public Currency add(Currency amount) {
        if (amount == null) {
            return new Currency(this.cent);
        }
        return new Currency(this.cent + amount.getCent());
    }

    public Currency subtract(Currency amount) {
        if (amount == null) {
            return new Currency(this.cent);
        }
        return new Currency(this.cent - amount.getCent());
    }
}
