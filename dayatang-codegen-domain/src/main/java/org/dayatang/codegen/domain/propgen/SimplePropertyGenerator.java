/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dayatang.codegen.domain.propgen;

import japa.parser.ASTHelper;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.AssignExpr.Operator;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dayatang.codegen.domain.classgen.PropertyGenerator;
import org.dayatang.codegen.tools.CodeGenUtils;

/**
 *
 * @author yyang
 */
public class SimplePropertyGenerator implements PropertyGenerator {

    public List<MethodDeclaration> generateAccessors(FieldDeclaration field) {
    	List<MethodDeclaration> results = new ArrayList<MethodDeclaration>();
    	results.add(generateGetter(field));
    	results.add(generateSetter(field));
    	return results;
    }

	private MethodDeclaration generateGetter(FieldDeclaration field) {
		String methodName = CodeGenUtils.getGetterMethodName(field);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, field.getType(), methodName);
		//String comments = "\r\n     * 取得" + field.getJavaDoc().getContent() 
		//		+ "\r\n     * @return " + fieldName + " " + field.getJavaDoc().getContent()
		//		+ "\r\n     ";
		//result.setJavaDoc(new JavadocComment(comments));
		String fieldName = field.getVariables().get(0).getId().getName();
		Statement returnStmt = new ReturnStmt(new NameExpr(fieldName));
		result.setBody(new BlockStmt(Arrays.asList(returnStmt)));
		return result;
	}

	private MethodDeclaration generateSetter(FieldDeclaration field) {
		String methodName = CodeGenUtils.getSetterMethodName(field);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, methodName);
		//String comments = "\r\n     * 设置" + field.getJavaDoc().getContent() 
		//		+ "\r\n     * @param " + fieldName + " " +  field.getJavaDoc().getContent()
		//		+ "\r\n     ";
		//result.setJavaDoc(new JavadocComment(comments));
		String fieldName = field.getVariables().get(0).getId().getName();
		Parameter parameter = ASTHelper.createParameter(field.getType(), fieldName);
		result.setParameters(Arrays.asList(parameter));
		AssignExpr assignExpr = new AssignExpr(new FieldAccessExpr(new NameExpr("this"), fieldName), new NameExpr(fieldName),
				Operator.assign);
		Statement es = new ExpressionStmt(assignExpr);
		BlockStmt setterBlockStmt = new BlockStmt(Arrays.asList(es));
		result.setBody(setterBlockStmt);
		return result;
	}
    
}
