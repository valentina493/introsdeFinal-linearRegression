package linearfitter.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("sdelab/resources")
public class LinearFitterApplicationConfig extends ResourceConfig {
	public LinearFitterApplicationConfig() {
		packages("linearfitter.rest.resources"); // Jersey will load all the resources under this package
	}
}