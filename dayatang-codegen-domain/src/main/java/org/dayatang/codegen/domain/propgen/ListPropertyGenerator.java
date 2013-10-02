package org.dayatang.codegen.domain.propgen;


public class ListPropertyGenerator extends AbstractCollectionPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableList";
	}

}
