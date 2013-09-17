package org.dayatang.codegen.domain.propgen;

import japa.parser.ASTHelper;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.AssignExpr.Operator;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.ThisExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dayatang.codegen.domain.classgen.PropertyGenerator;
import org.dayatang.codegen.tools.CodeGenUtils;

public class ArrayPropertyGenerator implements PropertyGenerator {

	public List<MethodDeclaration> generateAccessors(FieldDeclaration field) {
    	List<MethodDeclaration> results = new ArrayList<MethodDeclaration>();
    	results.add(generateGetter(field));
    	results.add(generateSetter(field));
    	return results;
	}

	private MethodDeclaration generateGetter(FieldDeclaration field) {
		String fieldName = field.getVariables().get(0).getId().getName();
		String methodName = "get" + CodeGenUtils.upperFirstLetter(fieldName);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, field.getType(), methodName);
		Expression arg = new FieldAccessExpr(new NameExpr(fieldName), "length");
		MethodCallExpr callExpr = new MethodCallExpr(new NameExpr("Arrays"), "copyOf", Arrays.asList(new NameExpr(fieldName), arg));
		Statement returnStmt = new ReturnStmt(callExpr);
		BlockStmt blockStmt = new BlockStmt(Arrays.asList(returnStmt));
		result.setBody(blockStmt);
		return result;
	}

	private MethodDeclaration generateSetter(FieldDeclaration field) {
		String fieldName = field.getVariables().get(0).getId().getName();
		String methodName = "set" + CodeGenUtils.upperFirstLetter(fieldName);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, methodName);
		Parameter parameter = ASTHelper.createParameter(field.getType(), fieldName);
		result.setParameters(Arrays.asList(parameter));
		Expression arg1 = new FieldAccessExpr(new ThisExpr(), fieldName);
		Expression arg2 = new FieldAccessExpr(new NameExpr(fieldName), "length");
		MethodCallExpr callExpr = new MethodCallExpr(new NameExpr("Arrays"), "copyOf", Arrays.asList(new NameExpr(fieldName), arg2));
		AssignExpr assignExpr = new AssignExpr(arg1, callExpr, Operator.assign);
		Statement es = new ExpressionStmt(assignExpr);
		BlockStmt setterBlockStmt = new BlockStmt(Arrays.asList(es));
		result.setBody(setterBlockStmt);
		return result;
	}

}
