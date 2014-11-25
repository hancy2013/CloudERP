package com.tutu.clouderp.rest.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutu.clouderp.Entity.JsonViews;
import com.tutu.clouderp.Entity.NewsEntry;
import com.tutu.clouderp.auth.entity.MM;
import com.tutu.clouderp.auth.repository.MMRepository;

@Component
@Path("/mm")
public class MMResource {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MMRepository mmRespository;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MM create(MM mm)
	{
		this.logger.info("create(): " + mm);

		return this.mmRespository.save(mm);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MM> list() throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");

		return this.mmRespository.findAll();
	}
}
