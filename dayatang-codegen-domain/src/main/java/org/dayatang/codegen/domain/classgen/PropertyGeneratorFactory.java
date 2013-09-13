/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import japa.parser.ast.body.FieldDeclaration;

/**
 *
 * @author yyang
 */
public interface PropertyGeneratorFactory {

    PropertyGenerator getGenerator(FieldDeclaration field);
    
}
