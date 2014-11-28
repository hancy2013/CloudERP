package com.tutu.clouderp.rest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.tutu.clouderp.Entity.MF;
@Component
@Path("/page")
public class CRUDPageResource extends BasicResource{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tid}/create/")
	public List<MF> getCreatePage(@PathParam("tid") String tid){
		return getDataStore().find(MF.class).asList();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{tid}")
	public List<MF> getUpdatePage(@PathParam("tid") String tid,@QueryParam("id") String id){
		//basicdao.getDataByTidAndId();
		return getDataStore().find(MF.class).asList();
	}
	
}
