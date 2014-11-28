package com.tutu.clouderp.Entity;

import java.math.BigDecimal;

public class MFNumber extends MF {
	private int length;
	private int decimalPlaces;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getDecimalPlaces() {
		return decimalPlaces;
	}
	public void setDecimalPlaces(int decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
	@Override
	Object getRealValue() {
		BigDecimal bd = new BigDecimal(getRawValue());
		bd.setScale(decimalPlaces,BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
}
