package com.tutu.clouderp.model;

import org.codehaus.jackson.annotate.JsonIgnore;


public class MFTime extends MF {

	public String getType() {
		return FieldType.TIME.getType();
	}

	@JsonIgnore
	public Object getRawValue() {
		return stringValue;
	}

}
