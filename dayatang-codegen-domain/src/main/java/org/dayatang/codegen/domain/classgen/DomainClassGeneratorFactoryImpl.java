/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.classgen;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.expr.AnnotationExpr;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dayatang.codegen.domain.DomainClassGenerator;
import org.dayatang.codegen.domain.DomainClassGeneratorFactory;

/**
 *
 * @author yyang
 */
public class DomainClassGeneratorFactoryImpl extends DomainClassGeneratorFactory {

    public DomainClassGenerator getGenerator(File file) {
        CompilationUnit cu;
        try {
            cu = JavaParser.parse(file);
        } catch (ParseException ex) {
            Logger.getLogger(DomainClassGeneratorFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            Logger.getLogger(DomainClassGeneratorFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        TypeDeclaration type = cu.getTypes().get(0);
        for (AnnotationExpr annotation : type.getAnnotations()) {
            String annotationName = annotation.getName().getName();
            if (annotationName.equalsIgnoreCase("Entity") || annotationName.equalsIgnoreCase("javax.persistence.Entity")) {
                return new EntityGenerator();
            }
            if (annotationName.equalsIgnoreCase("MappedSuperclass") || annotationName.equalsIgnoreCase("javax.persistence.MappedSuperclass")) {
                return new MappedSuperclassGenerator();
            }
            if (annotationName.equalsIgnoreCase("Embeddable") || annotationName.equalsIgnoreCase("javax.persistence.Embeddable")) {
                return new EmbeddableGenerator();
            }
        }
        return new NullGenerator();
    }
    
}
