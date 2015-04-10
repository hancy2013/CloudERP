package com.tutu.clouderp.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;


public class MFDate extends MF {
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
	@JsonIgnore
	public Object getRawValue() {
		Date date = null;
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		try {
			date = sdf.parse(stringValue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
