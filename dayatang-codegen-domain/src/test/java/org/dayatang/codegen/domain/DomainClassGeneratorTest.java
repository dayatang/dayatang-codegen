/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yyang
 */
public class DomainClassGeneratorTest {
    
    private String domainClass = "org.dayatang.codegen.domain.Employee";
    
    public DomainClassGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test() throws Exception {
        String path = toPath("org.dayatang.codegen.domain.Employee");
        System.out.println(path);
        String absolutePath = getClass().getResource(path).getFile();
        System.out.println(absolutePath);
        DomainClassGeneratorFactory factory = DomainClassGeneratorFactory.getInstance();
        DomainClassGenerator generator = factory.getGenerator(new File(absolutePath));
        generator.process(new File(absolutePath));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    private String toPath(String className) {
        return StringUtils.replace(className, ".", File.separator);
    }
}