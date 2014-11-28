package com.tutu.clouderp.rest.resources;

import java.util.Set;

import javax.annotation.Resource;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObjectBuilder;
import com.tutu.clouderp.base.BaseService;

@Path("/oper")
public class CRUDOperationResource extends BasicResource {
	@Resource
	private BaseService baseService;
	private static Logger logger = LoggerFactory.getLogger(CRUDOperationResource.class);

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tid}/del/{id}")
	public void delete(@PathParam("tid") String tid, @PathParam("id") String id) {
		logger.info("delete(id)");
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start().add("_id", id);
		getCollection(tid).remove(docBuilder.get());
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tid}/save/{id}")
	public void save(@PathParam("tid") String tid, @PathParam("id") String id, MultivaluedMap<String, String> parameter) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start().add("_id", id);
		Set<String> keys = parameter.keySet();
		for (String key : keys) {
			docBuilder.add(key, parameter.get(key));
		}
		getCollection(tid).save(docBuilder.get());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tid}/get/{id}")
	public void get(@PathParam("tid") String tid, @PathParam("id") String id) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start().add("_id", id);
		getCollection(tid).find(docBuilder.get());
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tid}/update/{id}")
	public void update(@PathParam("tid") String tid, @PathParam("id") String id,
			MultivaluedMap<String, String> parameter) {
		BasicDBObjectBuilder q = BasicDBObjectBuilder.start().add("_id", id);
		BasicDBObjectBuilder o = BasicDBObjectBuilder.start().add("_id", id);
		Set<String> keys = parameter.keySet();
		for (String key : keys) {
			o.add(key, parameter.get(key));
		}
		getCollection(tid).update(q.get(), o.get());
	}
}
