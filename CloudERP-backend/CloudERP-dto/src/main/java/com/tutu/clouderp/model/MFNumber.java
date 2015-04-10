package com.tutu.clouderp.model;

import org.codehaus.jackson.annotate.JsonIgnore;



public class MFNumber extends MFText {
	private int scale;
	public String getType() {
		return FieldType.NUMBER.getType();
	}
	@JsonIgnore
	public Object getRawValue() {
		return new Double(stringValue);
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
}
