package com.tutu.clouderp.model;

public class MFAutoCode extends MFText{
	private String format;
	private String startno;
	private boolean generateforexistrecords;
	public String getType() {
		return FieldType.AUTOCODE.getType();
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getStartno() {
		return startno;
	}
	public void setStartno(String startno) {
		this.startno = startno;
	}
	public boolean isGenerateforexistrecords() {
		return generateforexistrecords;
	}
	public void setGenerateforexistrecords(boolean generateforexistrecords) {
		this.generateforexistrecords = generateforexistrecords;
	}
}
