package ar.com.nutribot.service.jaxrs;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

/**
 * 
 * @author lfishkel 
 */

@Provider
@ServerInterceptor
public class CorsInterceptor implements PreProcessInterceptor,
		MessageBodyWriterInterceptor {


	/**
	 * The Access-Control-Allow-Origin header indicates which origin a resource
	 * it is specified for can be shared with. ABNF: Access-Control-Allow-Origin
	 * = "Access-Control-Allow-Origin" ":" source origin string | "*"
	 */
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";


	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
			throws Failure, WebApplicationException {
		// Antes de cada request entra aca

		return null;
	}

	@Override
	public void write(MessageBodyWriterContext context) throws IOException,
			WebApplicationException {
		context.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		context.proceed();
	}
}
