package ar.com.nutribot.service.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@ApplicationPath("/")
public class JaxRsActivator extends Application {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String home(){
		return "nutribot services";
	}
}