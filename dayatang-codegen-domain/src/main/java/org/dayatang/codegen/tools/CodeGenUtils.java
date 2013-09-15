package org.dayatang.codegen.tools;

public class CodeGenUtils {

	public static String upperFirstLetter(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	public static String getCollectionElementType(String dataType) {
		return getSubString(dataType, "<", ">");
	}

	public static String getMapKeyType(String dataType) {
		return getSubString(dataType, "<", ",");
	}

	public static String getMapValueType(String dataType) {
		return getSubString(dataType, ",", ">");
	}
	
	private static String getSubString(String str, String prefix, String suffix) {
		int start = str.indexOf(prefix);
		int end = str.lastIndexOf(suffix);
		if (start < 0 || end < 0 || end < start) {
			throw new IllegalArgumentException("Type '" + str + "' is invalid");
		}
		return str.substring(start + 1, end).trim();
	}
}
