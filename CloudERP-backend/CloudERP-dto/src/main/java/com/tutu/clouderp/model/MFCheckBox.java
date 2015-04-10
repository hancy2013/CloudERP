package com.tutu.clouderp.model;

import org.codehaus.jackson.annotate.JsonIgnore;

public class MFCheckBox extends MF{
	private String description;
	
	public String getType() {
		return FieldType.CHECKBOX.getType();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Object getRawValue() {
		return stringValue;
	}

}
