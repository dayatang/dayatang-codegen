package org.dayatang.codegen.domain.propgen;
public class SetPropertyGenerator extends AbstractCollectionPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableSet";
	}

}
