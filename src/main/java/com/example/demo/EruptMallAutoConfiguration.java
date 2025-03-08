package com.example.demo;

import com.example.demo.model.Component;
import com.example.demo.model.CurdDemo;
import com.example.demo.model.Simple;
import com.example.demo.model.TreeView;
import com.example.demo.model.complex.Complex;
import com.example.demo.model.mall.Coupon;
import com.example.demo.model.mall.Goods;
import com.example.demo.model.mall.GoodsCategory;
import com.example.demo.model.mall.GoodsSpec;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import xyz.erupt.core.annotation.EruptScan;
import xyz.erupt.core.constant.MenuTypeEnum;
import xyz.erupt.core.module.EruptModule;
import xyz.erupt.core.module.EruptModuleInvoke;
import xyz.erupt.core.module.MetaMenu;
import xyz.erupt.core.module.ModuleInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jAmEs_
 * date 2025/3/8
 */
@Configuration
@ComponentScan
@EntityScan
@EruptScan
@EnableConfigurationProperties
public class EruptMallAutoConfiguration implements EruptModule {

    static {
        EruptModuleInvoke.addEruptModule(EruptMallAutoConfiguration.class);
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt-mall").build();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        MetaMenu root = MetaMenu.createRootMenu("$mall", "电商管理", "fa fa-cogs", 1);
        menus.add(root);
        menus.add(MetaMenu.createEruptClassMenu(GoodsCategory.class, root, 0));
        menus.add(MetaMenu.createEruptClassMenu(Goods.class, root, 10));
        menus.add(MetaMenu.createEruptClassMenu(Coupon.class, root, 20));
        return menus;
    }

}
