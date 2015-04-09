package com.tutu.clouderp.model;

public class MFDate extends MF{
	protected String format;
	public String getType() {
		return FieldType.DATE.getType();
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

}
