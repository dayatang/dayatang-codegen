/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain;

import java.io.File;


/**
 * 根据文件自动找到相应的领域类生成器
 * @author yyang
 */
public interface DomainClassGeneratorFactory {
    
    DomainClassGenerator getGenerator(File file);
}
