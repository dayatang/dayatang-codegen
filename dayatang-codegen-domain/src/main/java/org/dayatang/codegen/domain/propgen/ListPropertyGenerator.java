package org.dayatang.codegen.domain.propgen;


public class ListPropertyGenerator extends CollectionPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableList";
	}

}
