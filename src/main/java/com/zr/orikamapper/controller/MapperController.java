package com.zr.orikamapper.controller;

import com.alibaba.fastjson.JSONObject;
import com.zr.orikamapper.entity.Currency;
import com.zr.orikamapper.entity.Player;
import com.zr.orikamapper.entity.PlayerName;
import com.zr.orikamapper.entity.Price;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "", description = "")
public class MapperController {

    @Resource
    private MapperFacade mapperFacade;

    @GetMapping("price/{cent}")
    @ApiOperation(value = "showPriceMapper", notes = "")
    public String showPriceMapper(@PathVariable("cent") Long cent){
        Currency currency = new Currency(cent);
        Price price = mapperFacade.map(currency, Price.class);
        return JSONObject.toJSONString(price);
    }

    @PostMapping("player")
    @ApiOperation(value = "showPlayerMapper", notes = "")
    public String showPlayerMapper(@RequestBody Player player){
        PlayerName name = mapperFacade.map(player, PlayerName.class);
        return JSONObject.toJSONString(name);
    }
}
