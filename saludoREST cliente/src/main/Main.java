package main;




import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;




public class Main {

	public static void main(String[] args) {
		
		String url= "http://localhost:8080/saludoREST/servicios/saludo/wsb";
		

	
		
		Client cliente = ClientBuilder.newClient();
		
		//GET
		String res= cliente.target(url + "/Charlton/Heston").request().get(String.class);
				
		System.out.println(res);
	
		//POST
		res= cliente.target(url).request().post(Entity.text("Gwyneth, Paltrow"), String.class);

		System.out.println(res);
		
		//DELETE
		res= cliente.target(url + "?nombre=Miguel&apellido=Ríos").request().delete(String.class);
		
		System.out.println(res);
				
		//PUT
		Form form= new Form();
		form.param("nombre", "Melania");
		form.param("apellido", "sdfgsdfgsdfgsdfgsdfgdfg");
				
		res= cliente.target(url).request().put(Entity.form(form), String.class);

		System.out.println(res);
	
		cliente.close();
		
		}
	
		

}
