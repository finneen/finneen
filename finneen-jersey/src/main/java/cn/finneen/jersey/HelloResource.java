package cn.finneen.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/hello")
public class HelloResource {
	
	@GET
	@Path(value = "/{firstName}/{lastName}/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object greed(@PathParam(value = "firstName") String firstName, @PathParam(value = "lastName") String lastName, @PathParam( value = "age") long age) {
		return new HelloBean(firstName, lastName, age);
	}

}
