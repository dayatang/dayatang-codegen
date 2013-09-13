/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import com.dayatang.domain.InstanceFactory;
import japa.parser.ASTHelper;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author yyang
 */
class FieldVisitorAdapter extends VoidVisitorAdapter {
    
    private PropertyGeneratorFactory propertyGeneratorFactory;
    
    public PropertyGeneratorFactory getPropertyGeneratorFactory() {
        if (propertyGeneratorFactory == null) {
            propertyGeneratorFactory = InstanceFactory.getInstance(PropertyGeneratorFactory.class);
        }
        return propertyGeneratorFactory;
    }
    
    public void setPropertyGeneratorFactory(PropertyGeneratorFactory propertyGeneratorFactory) {
        this.propertyGeneratorFactory = propertyGeneratorFactory;
    }

    @Override
    public void visit(FieldDeclaration field, Object type) {
            PropertyGenerator propertyGenerator = getPropertyGeneratorFactory().getGenerator(field);
            for (MethodDeclaration method : propertyGenerator.generateAccessors(field)) {
                ASTHelper.addMember((TypeDeclaration) type, method);
            }
    }
}
