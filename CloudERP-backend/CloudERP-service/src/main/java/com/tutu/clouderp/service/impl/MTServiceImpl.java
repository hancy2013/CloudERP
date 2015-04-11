package com.tutu.clouderp.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.tutu.clouderp.api.MTService;
import com.tutu.clouderp.model.MT;
import com.tutu.clouderp.service.BasicService;

@Service("mtService")
@Path("/mt")
public class MTServiceImpl extends BasicService implements MTService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MT> list() {
		return getDataStore().find(MT.class).asList();
	}

	@GET
	@Path("{mid}")
	@Produces(MediaType.APPLICATION_JSON)
	public MT mt(@PathParam("mid") String mid) {
		return getDataStore().get(MT.class,  new ObjectId(mid));
	}

}
