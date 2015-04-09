package com.tutu.clouderp.model;

public enum FieldType {
	TEXT("text"),
	NUMBER("number"),
	DATE("date"),
	TIME("time"),
	SELECT("select"),
	MULTISELECT("multiselect"),
	AUTOCODE("autocode"),
	CHECKBOX("checkbox");
	private final String type;

	FieldType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
