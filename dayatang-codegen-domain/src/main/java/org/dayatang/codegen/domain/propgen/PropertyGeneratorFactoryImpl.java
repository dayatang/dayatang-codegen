/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.propgen;

import japa.parser.ast.body.FieldDeclaration;

import org.dayatang.codegen.domain.classgen.PropertyGenerator;
import org.dayatang.codegen.domain.classgen.PropertyGeneratorFactory;

/**
 *
 * @author yyang
 */
public class PropertyGeneratorFactoryImpl implements PropertyGeneratorFactory {

    public PropertyGenerator getGenerator(FieldDeclaration field) {
    	String fieldType = field.getType().toString();
    	System.out.println(fieldType);
    	if (fieldType.startsWith("List")) {
    		return new ListPropertyGenerator();
    	}
    	if (fieldType.startsWith("Set")) {
    		return new SetPropertyGenerator();
    	}
    	if (fieldType.startsWith("Collection")) {
    		return new ListPropertyGenerator();
    	}
    	if (fieldType.startsWith("SortedSet")) {
    		return new SortedSetPropertyGenerator();
    	}
    	if (fieldType.startsWith("Map")) {
    		return new MapPropertyGenerator();
    	}
    	if (fieldType.startsWith("SortedMap")) {
    		return new SortedMapPropertyGenerator();
    	}
    	if (fieldType.endsWith("[]")) {
    		return new ArrayPropertyGenerator();
    	}
        //System.out.println(field.getVariables().get(0).getId().getName() + ": " + field.getType() + ": " + field.getType().getClass());
        return new SimplePropertyGenerator();
    }
    
}
