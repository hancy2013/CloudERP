package com.tutu.clouderp.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="newentry")
public class NewsEntry implements Entity
{

	private static final long serialVersionUID = 1L;

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