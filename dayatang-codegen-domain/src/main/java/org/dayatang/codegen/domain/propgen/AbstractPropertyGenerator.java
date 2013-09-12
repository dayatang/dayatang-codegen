/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.propgen;

import org.dayatang.codegen.domain.classgen.*;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import java.util.List;

/**
 *
 * @author yyang
 */
public abstract class AbstractPropertyGenerator {
    
    protected FieldDeclaration field;
    
    public AbstractPropertyGenerator(FieldDeclaration field) {
        this.field = field;
    }

    public List<MethodDeclaration> generateAccessors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
