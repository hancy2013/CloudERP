package com.tutu.clouderp.model;

import org.codehaus.jackson.annotate.JsonIgnore;


public class MFText extends MF {
	protected boolean isunique;
	protected String placeholder;
	protected String description;

	public String getType() {
		return FieldType.TEXT.getType();
	}

	public boolean isIsunique() {
		return isunique;
	}

	public void setIsunique(boolean isunique) {
		this.isunique = isunique;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore(true)
	public Object getRawValue() {
		return stringValue;
	}
}
