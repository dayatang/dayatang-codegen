package org.dayatang.codegen.domain.propgen;

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;

import java.util.ArrayList;
import java.util.List;

import org.dayatang.codegen.domain.classgen.PropertyGenerator;

public class MapPropertyGenerator implements PropertyGenerator {

	public List<MethodDeclaration> generateAccessors(FieldDeclaration field) {
		List<MethodDeclaration> results = new ArrayList<MethodDeclaration>();
    	results.add(generateGetter(field));
    	results.add(generateAddElementMethod(field));
    	results.add(generateRemoveElementMethod(field));
		return results;
	}

	private MethodDeclaration generateGetter(FieldDeclaration field) {
		// TODO Auto-generated method stub
		return null;
	}

	private MethodDeclaration generateAddElementMethod(FieldDeclaration field) {
		// TODO Auto-generated method stub
		return null;
	}

	private MethodDeclaration generateRemoveElementMethod(FieldDeclaration field) {
		// TODO Auto-generated method stub
		return null;
	}

}
