/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.propgen;

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.type.Type;
import org.dayatang.codegen.domain.classgen.PropertyGenerator;
import org.dayatang.codegen.domain.classgen.PropertyGeneratorFactory;

/**
 *
 * @author yyang
 */
public class PropertyGeneratorFactoryImpl implements PropertyGeneratorFactory {

    public PropertyGenerator getGenerator(FieldDeclaration field) {
        Type type = field.getType();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
