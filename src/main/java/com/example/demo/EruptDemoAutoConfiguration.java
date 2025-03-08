package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.model.blog.*;
import com.example.demo.model.complex.Complex;
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
public class EruptDemoAutoConfiguration implements EruptModule {

    static {
        EruptModuleInvoke.addEruptModule(EruptDemoAutoConfiguration.class);
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt-demo").build();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        MetaMenu root = MetaMenu.createRootMenu("$demo", "demo管理", "fa fa-cogs", 1);
        menus.add(root);
        menus.add(MetaMenu.createEruptClassMenu(Component.class, root, 0));
        menus.add(MetaMenu.createEruptClassMenu(CurdDemo.class, root, 10));
        menus.add(MetaMenu.createEruptClassMenu(Simple.class, root, 20));
        menus.add(MetaMenu.createEruptClassMenu(TreeView.class, root, 30, MenuTypeEnum.TREE));
        menus.add(MetaMenu.createEruptClassMenu(Complex.class, root, 40));
        menus.add(MetaMenu.createEruptClassMenu(Article.class, root, 50));
        return menus;
    }

}
