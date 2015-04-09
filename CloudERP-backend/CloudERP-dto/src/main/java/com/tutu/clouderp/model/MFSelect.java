package com.tutu.clouderp.model;

public class MFSelect extends MF{
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

}
