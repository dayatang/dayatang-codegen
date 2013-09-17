package org.dayatang.codegen.domain.propgen;

import japa.parser.ASTHelper;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.ThisExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.dayatang.codegen.domain.classgen.PropertyGenerator;
import org.dayatang.codegen.tools.CodeGenUtils;
import org.dayatang.codegen.tools.Inflector;

public abstract class CollectionPropertyGenerator implements PropertyGenerator {

	public List<MethodDeclaration> generateAccessors(FieldDeclaration field) {
    	List<MethodDeclaration> results = new ArrayList<MethodDeclaration>();
    	results.add(generateGetter(field));
    	results.add(generateAddElementMethod(field));
    	results.add(generateRemoveElementMethod(field));
    	results.add(generateClearMethod(field));
    	return results;
	}

	private MethodDeclaration generateGetter(FieldDeclaration field) {
		String fieldName = field.getVariables().get(0).getId().getName();
		String methodName = "get" + CodeGenUtils.upperFirstLetter(fieldName);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, field.getType(), methodName);
		Expression arg = new FieldAccessExpr(new ThisExpr(), fieldName);
		MethodCallExpr callExpr = new MethodCallExpr(new NameExpr("Collections"), getUnmodifiableCloneMethodName(), Collections.singletonList(arg));
		Statement returnStmt = new ReturnStmt(callExpr);
		BlockStmt blockStmt = new BlockStmt(Arrays.asList(returnStmt));
		result.setBody(blockStmt);
		return result;
	}

	private MethodDeclaration generateAddElementMethod(FieldDeclaration field) {
		String fieldName = field.getVariables().get(0).getId().getName();
		String methodName = "add" + CodeGenUtils.upperFirstLetter(fieldName);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, methodName);
		String argName = Inflector.getInstance().singularize(fieldName);
		Parameter parameter = ASTHelper.createParameter(new ClassOrInterfaceType(CodeGenUtils.getCollectionElementType(field.getType().toString())), argName);
		result.setParameters(Arrays.asList(parameter));

		Expression args = new NameExpr(argName);
		MethodCallExpr callExpr = new MethodCallExpr(new NameExpr(fieldName), "add", Arrays.asList(args));
		Statement es = new ExpressionStmt(callExpr);
		BlockStmt setterBlockStmt = new BlockStmt(Arrays.asList(es));
		result.setBody(setterBlockStmt);
		return result;
	}

	private MethodDeclaration generateRemoveElementMethod(FieldDeclaration field) {
		String fieldName = field.getVariables().get(0).getId().getName();
		String methodName = "remove" + CodeGenUtils.upperFirstLetter(fieldName);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, methodName);
		String argName = Inflector.getInstance().singularize(fieldName);
		Parameter parameter = ASTHelper.createParameter(new ClassOrInterfaceType(CodeGenUtils.getCollectionElementType(field.getType().toString())), argName);
		result.setParameters(Arrays.asList(parameter));

		Expression args = new NameExpr(argName);
		MethodCallExpr callExpr = new MethodCallExpr(new NameExpr(fieldName), "remove", Arrays.asList(args));
		Statement es = new ExpressionStmt(callExpr);
		BlockStmt setterBlockStmt = new BlockStmt(Arrays.asList(es));
		result.setBody(setterBlockStmt);
		return result;
	}

	private MethodDeclaration generateClearMethod(FieldDeclaration field) {
		String fieldName = field.getVariables().get(0).getId().getName();
		String methodName = "clear" + CodeGenUtils.upperFirstLetter(fieldName);
		MethodDeclaration result = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, methodName);
		MethodCallExpr callExpr = new MethodCallExpr(new NameExpr(fieldName), "clear");
		Statement es = new ExpressionStmt(callExpr);
		BlockStmt setterBlockStmt = new BlockStmt(Arrays.asList(es));
		result.setBody(setterBlockStmt);
		return result;
	}

	protected abstract String getUnmodifiableCloneMethodName();
}
