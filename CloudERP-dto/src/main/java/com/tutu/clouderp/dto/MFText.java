package com.tutu.clouderp.dto;

public class MFText extends MF{

	@Override
	Object getRealValue() {
		return getRawValue();
	}
}
