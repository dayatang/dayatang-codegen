package org.dayatang.codegen.domain.propgen;


public class SortedSetPropertyGenerator extends AbstractCollectionPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableSortedSet";
	}


}
