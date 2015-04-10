package com.tutu.clouderp.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.tutu.clouderp.dto.BaseEntity;

/**
 * 元数据字段
 * 
 * @Title MF.java
 * @Package com.passionguy.force.dto
 * @Description
 * @author tutu
 * @date 2014-11-20
 */
public abstract class MF extends BaseEntity {
	protected String key;
	protected String label;
	protected boolean required;
	protected boolean disabled;
	protected String defaultValue;

	protected String stringValue;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	abstract String getType();

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	@JsonIgnore
	public abstract Object getRawValue();
}
