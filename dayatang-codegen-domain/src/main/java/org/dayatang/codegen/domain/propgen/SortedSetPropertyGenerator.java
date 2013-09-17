package org.dayatang.codegen.domain.propgen;


public class SortedSetPropertyGenerator extends CollectionPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableSortedSet";
	}


}
