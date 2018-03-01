package negocio.saludo.wsb;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import negocio.FactoriaNegocio;

@Path("/saludo/wsb")
public class SaludoWSB {
	
	@GET
	@Path("/{nombre}/{apellido}")
	@Produces("text/plain")
	public String readGET(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido)
	{
		
		return FactoriaNegocio.getInstancia().nuevoSaludo().saludar(nombre+" "+apellido+"-GET");
	}
	
	@POST
	public Response readPOST(String s)
	{
		List<String> l = Arrays.asList(s.split("\\s*,\\s*"));
		String nombre= l.get(0);
		String apellido= l.get(1); 
		String res= FactoriaNegocio.getInstancia().nuevoSaludo().saludar(nombre+" "+apellido+"-POST");
		
		return Response.ok(res).build();
	}
	
	@DELETE
	@Produces("text/plain")
	public String readDELETE(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido)
	{
		
		return FactoriaNegocio.getInstancia().nuevoSaludo().saludar(nombre+" "+apellido+"-DELETE");
	}

	@PUT
	public String readPUT(@FormParam("nombre") String nombre, @FormParam("apellido") String apellido)
	{
	
		String res= FactoriaNegocio.getInstancia().nuevoSaludo().saludar(nombre+" "+apellido+"-PUT");
		
		return res;
	}
	
	
}
