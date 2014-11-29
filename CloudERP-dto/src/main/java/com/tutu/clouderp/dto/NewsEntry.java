package com.tutu.clouderp.dto;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("newentry")
public class NewsEntry
{

	@Id
	private String id;

	private Date date;

	private String content;


	public NewsEntry()
	{
		this.date = new Date();
	}


	public String getId()
	{
		return this.id;
	}


	public Date getDate()
	{
		return this.date;
	}


	public void setDate(Date date)
	{
		this.date = date;
	}


	public String getContent()
	{
		return this.content;
	}


	public void setContent(String content)
	{
		this.content = content;
	}


	@Override
	public String toString()
	{
		return this.id+this.content;
	}

}