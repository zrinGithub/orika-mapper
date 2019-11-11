package com.zr.orikamapper.config;

import com.zr.orikamapper.entity.Currency;
import com.zr.orikamapper.entity.Player;
import com.zr.orikamapper.entity.PlayerName;
import com.zr.orikamapper.entity.Price;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

@Component
public class OrikaCustomMapping implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory factory) {
        //设定两个字段的关联，只需要使用field关联字段
        factory.classMap(Currency.class, Price.class)
                .field("yuanFmt","showPrice")
                .byDefault()
                .register();
        //涉及到类型转换或者需要处理，需要自己定制转换类
        factory.classMap(Player.class, PlayerName.class)
                .customize(new CustomMapper<Player, PlayerName>() {
                    @Override
                    public void mapAtoB(Player player, PlayerName name, MappingContext context) {
                        name.setFirstName(player.getName().split(" ")[0]);
                        name.setLastName(player.getName().split(" ")[1]);
                    }
                })
                .register();
    }
}
