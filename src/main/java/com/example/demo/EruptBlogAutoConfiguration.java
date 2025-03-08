package com.example.demo;

import com.example.demo.model.blog.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import xyz.erupt.core.annotation.EruptScan;
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
public class EruptBlogAutoConfiguration implements EruptModule {

    static {
        EruptModuleInvoke.addEruptModule(EruptBlogAutoConfiguration.class);
    }

    @Override
    public ModuleInfo info() {
        return ModuleInfo.builder().name("erupt-blog").build();
    }

    @Override
    public List<MetaMenu> initMenus() {
        List<MetaMenu> menus = new ArrayList<>();
        MetaMenu root = MetaMenu.createRootMenu("$blog", "博客管理", "fa fa-cogs", 1);
        menus.add(root);
        menus.add(MetaMenu.createEruptClassMenu(BlogCategory.class, root, 0));
        menus.add(MetaMenu.createEruptClassMenu(BlogTag.class, root, 10));
        menus.add(MetaMenu.createEruptClassMenu(FriendlyLink.class, root, 20));
        menus.add(MetaMenu.createEruptClassMenu(PicturesCategory.class, root, 30));
        menus.add(MetaMenu.createEruptClassMenu(Pictures.class, root, 40));
        menus.add(MetaMenu.createEruptClassMenu(Blog.class, root, 50));
        return menus;
    }

}
