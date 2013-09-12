/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import japa.parser.ast.body.FieldDeclaration;
import java.util.ServiceLoader;

/**
 *
 * @author yyang
 */
public abstract class PropertyGeneratorFactory {
    
    public static PropertyGeneratorFactory getInstance() {
        return ServiceLoader.load(PropertyGeneratorFactory.class).iterator().next();
    }

    public PropertyGenerator getGenerator(FieldDeclaration field) {
        return getInstance().getGenerator(field);
    }
    
}
