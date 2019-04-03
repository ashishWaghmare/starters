package in.apptitute.resources;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.caching.CacheControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.validation.Validator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class ComingSoonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComingSoonController.class);

    private final AtomicLong counter;


    public ComingSoonController() {
        this.counter = new AtomicLong();

    }

    @GET
    @Timed(name = "get-requests-timed")
    @Metered(name = "get-requests-metered")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Response sayHello() {
        return Response.ok().entity("TODO from evn variable").build();
    }
}