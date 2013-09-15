/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import japa.parser.ASTHelper;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dayatang.codegen.domain.DomainClassGenerator;

import com.dayatang.domain.InstanceFactory;

/**
 *
 * @author yyang
 */
public abstract class AbstractDomainClassGenerator implements DomainClassGenerator {
    protected File file;
    protected CompilationUnit compilationUnit;
    protected TypeDeclaration type;
    
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
    	for (FieldDeclaration field : getFields()) {
            PropertyGenerator propertyGenerator = getPropertyGeneratorFactory().getGenerator(field);
            for (MethodDeclaration method : propertyGenerator.generateAccessors(field)) {
                ASTHelper.addMember((TypeDeclaration) type, method);
            }
    	}
    }

	private List<FieldDeclaration> getFields() {
		List<FieldDeclaration> results = new ArrayList<FieldDeclaration>();
		for (BodyDeclaration member : type.getMembers()) {
			if (member instanceof FieldDeclaration) {
				results.add((FieldDeclaration) member);
			}
		}
		return results;
	}


}
