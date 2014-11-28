package com.tutu.clouderp.Entity;

import org.mongodb.morphia.annotations.Id;

public class Org {
	@Id
	private String id;
	private Org parentOrg;
	private String name;
}
