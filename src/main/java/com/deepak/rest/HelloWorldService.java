package com.deepak.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
      String output = "<B>This web-service is a Eclipse plain java project using Jersey JAX-RS</B><BR/>";
      output += " This was made from scratch and has no ant/maven support and war built and deployed manually<BR/><BR/>";  
      output += "Jersey says : " + msg;
 
		return Response.status(200).entity(output).build();
	}
 
}