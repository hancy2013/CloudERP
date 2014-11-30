package com.tutu.clouderp.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.tutu.clouderp.api.OrgService;
import com.tutu.clouderp.dto.Org;
import com.tutu.clouderp.service.BasicService;
@Service("orgService")
@Path("/org")
public class OrgServiceImpl extends BasicService implements OrgService{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Org> list() {
		return getDataStore().find(Org.class).asList();
	}

}
