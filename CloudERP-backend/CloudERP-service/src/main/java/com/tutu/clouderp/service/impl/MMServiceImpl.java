package com.tutu.clouderp.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tutu.clouderp.api.MMService;
import com.tutu.clouderp.auth.dao.SystemDatastore;
import com.tutu.clouderp.dto.auth.MM;
@Service("mmService")
@Path("/mm")
public class MMServiceImpl implements MMService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SystemDatastore systemDatastore;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MM create(MM mm)
	{
		this.logger.info("create(): " + mm);

		this.systemDatastore.save(mm);
		
		return mm;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MM> list() throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");

		return this.systemDatastore.find(MM.class).asList();
	}

}
