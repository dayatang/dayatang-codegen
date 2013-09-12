/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import java.util.List;

/**
 *
 * @author yyang
 */
public interface PropertyGenerator {

    List<MethodDeclaration> generateAccessors(FieldDeclaration field);
    
}
