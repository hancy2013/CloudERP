package com.tutu.clouderp.Entity;

import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;


public class MFText extends MF{
	public MFText(){
		type=TypeEnum.TEXT;
	}
	public BasicBSONObject toBson(){
		BasicBSONObject field=new BasicBSONObject();
		field.put("id", new ObjectId());
		field.put("name", getName());
		field.put("type", type.name());
		return field;
	}
}
