package org.dayatang.codegen.domain.propgen;



public class SetPropertyGenerator extends CollectionPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableSet";
	}

}
