package resource;

import counter.Counter;
import dto.CounterDTO;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("/counter")
public class MainResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        CounterDTO dto = new CounterDTO(LocalDateTime.now(), Counter.get());
        return Response.ok(dto).build();
    }

    @POST
    public Response increment() {
        Counter.increment();
        return Response.ok().build();
    }

    @POST
    @Path("/clear")
    public Response clear(@CookieParam("hh-auth") String cookie) {
        if (cookie.length() > 10) {
            Counter.clear();
        }
        return Response.ok().build();
    }

    @DELETE
    public Response decrease(@HeaderParam("Subtraction-Value") int value) {
        Counter.decrease(value);
        return Response.ok().build();
    }

}
