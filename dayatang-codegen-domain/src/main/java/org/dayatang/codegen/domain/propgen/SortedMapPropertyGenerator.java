package org.dayatang.codegen.domain.propgen;


public class SortedMapPropertyGenerator extends AbstractMapPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableSortedMap";
	}

}
