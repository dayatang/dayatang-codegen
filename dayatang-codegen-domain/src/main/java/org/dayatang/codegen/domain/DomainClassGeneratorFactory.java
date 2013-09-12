/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain;

import java.io.File;
import java.util.ServiceLoader;


/**
 * 根据文件自动找到相应的领域类生成器
 * @author yyang
 */
public abstract class DomainClassGeneratorFactory {
    
    public static DomainClassGeneratorFactory getInstance() {
        return ServiceLoader.load(DomainClassGeneratorFactory.class).iterator().next();
    }
    
    public DomainClassGenerator getGenerator(File file) {
        return getInstance().getGenerator(file);
    }
}
