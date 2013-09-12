/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

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

    public FieldVisitorAdapter() {
    }

    @Override
    public void visit(FieldDeclaration field, Object type) {
            PropertyGenerator propertyGenerator = PropertyGeneratorFactory.getInstance().getGenerator(field);
            for (MethodDeclaration method : propertyGenerator.generateAccessors(field)) {
                ASTHelper.addMember((TypeDeclaration) type, method);
            }
    }
}
