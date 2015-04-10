package com.tutu.clouderp.model;

import org.codehaus.jackson.annotate.JsonIgnore;


public class MFSelect extends MF {
	protected String[] options;

	public String getType() {
		return FieldType.SELECT.getType();
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	@JsonIgnore(true)
	public Object getRawValue() {
		return stringValue;
	}

}
