/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.io.File;
import java.io.IOException;
import org.dayatang.codegen.domain.DomainClassGenerator;

/**
 *
 * @author yyang
 */
public abstract class AbstractDomainClassGenerator implements DomainClassGenerator {
    protected File file;
    protected CompilationUnit compilationUnit;
    protected TypeDeclaration type;
    
    @Override
    public void process(File file) {
        this.file = file;
        compilationUnit = createCompilationUnit(file);
        type = compilationUnit.getTypes().get(0);
        generateAccessors();

    }

    private CompilationUnit createCompilationUnit(File file) {
        try {
            return JavaParser.parse(file);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void generateAccessors() {
        VoidVisitorAdapter visitor = new FieldVisitorAdapter();
        visitor.visit(compilationUnit, type);
    }


}
