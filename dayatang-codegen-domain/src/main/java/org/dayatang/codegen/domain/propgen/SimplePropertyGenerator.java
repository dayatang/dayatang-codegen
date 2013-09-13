/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.propgen;

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import java.util.List;
import org.dayatang.codegen.domain.classgen.PropertyGenerator;

/**
 *
 * @author yyang
 */
public class SimplePropertyGenerator implements PropertyGenerator {

    public List<MethodDeclaration> generateAccessors(FieldDeclaration field) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
