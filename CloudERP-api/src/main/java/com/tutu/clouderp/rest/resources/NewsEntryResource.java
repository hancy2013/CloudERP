package com.tutu.clouderp.rest.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutu.clouderp.Entity.JsonViews;
import com.tutu.clouderp.Entity.NewsEntry;
import com.tutu.clouderp.auth.entity.User;
import com.tutu.clouderp.repository.NewsRepository;
import com.tutu.clouderp.session.SessionHolder;


@Component
@Path("/news")
public class NewsEntryResource
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private NewsRepository newsRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String list() throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");

		ObjectWriter viewWriter;
		if (this.isAdmin()) {
			viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
		} else {
			viewWriter = this.mapper.writerWithView(JsonViews.User.class);
		}
		List<NewsEntry> allEntries = this.newsRepository.findAll();

		return viewWriter.writeValueAsString(allEntries);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public NewsEntry read(@PathParam("id") String id)
	{
		this.logger.info("read(id)");

		NewsEntry newsEntry = this.newsRepository.findById(id);
		if (newsEntry == null) {
			throw new WebApplicationException(404);
		}
		return newsEntry;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public NewsEntry create(NewsEntry newsEntry)
	{
		this.logger.info("create(): " + newsEntry);

		return this.newsRepository.save(newsEntry);
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public NewsEntry update(@PathParam("id") String id, NewsEntry newsEntry)
	{
		this.logger.info("update(): " + newsEntry);

		return this.newsRepository.save(newsEntry);
	}


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public void delete(@PathParam("id") String id)
	{
		this.logger.info("delete(id)");

		this.newsRepository.delete(id);
	}


	private boolean isAdmin()
	{
		User user=SessionHolder.getSession();
		if(user==null) return false;
		return SessionHolder.getSession().getRoles().contains("admin");
	}

}