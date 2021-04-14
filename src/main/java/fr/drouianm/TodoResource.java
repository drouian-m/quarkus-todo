package fr.drouianm;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/todo")
@Produces("application/json")
@Consumes("application/json")
public class TodoResource {
    @GET
    public List<Todo> get() {
        return Todo.listAll();
    }

    @POST
    @Transactional
    public Response create(Todo todo) {
        if (todo.id != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
 
        todo.persist();
        return Response.ok(todo).status(201).build();
    }
}
