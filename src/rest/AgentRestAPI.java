package rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import agent.Agent;
import agent.AgentType;
import message.ACLMessage;


@Remote
public interface AgentRestAPI
{
	@POST
	@Path("/running/{type}/{name}")
	public Response startAgents(@PathParam("type") String type, @PathParam("name") String name);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addRunningAgent")
	public Response addRunningAgent(Agent newAgent);
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Agent> test();
	
	@GET
	@Path("/classes")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ArrayList<AgentType>> classes();
	
	@DELETE
	@Path("/running")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAgent(@PathParam("type") String type,@PathParam("name") String name);
	
	
	@DELETE
	@Path("/removeRunningAgent/{type}/{name}")
	public Response removeRunningAgent(@PathParam("type") String type,@PathParam("name") String name);

	
}
