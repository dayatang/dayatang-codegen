package org.dayatang.codegen.domain.propgen;


public class MapPropertyGenerator extends AbstractMapPropertyGenerator {

	@Override
	protected String getUnmodifiableCloneMethodName() {
		return "unmodifiableMap";
	}

}
