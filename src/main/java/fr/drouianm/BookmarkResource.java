package fr.drouianm;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/bookmarks")
@Produces("application/json")
@Consumes("application/json")
public class BookmarkResource {

  @Inject
  BookmarkService bookmarkService;
  
  @OPTIONS
  public Response opt() {
    return Response.ok().build();
  }

  @GET
  public List<Bookmark> get() {
    return bookmarkService.fetch();
  }

  @GET
  @Path("/{id}")
  public Bookmark getOne(@PathParam("id") Long id) {
    Bookmark entity = bookmarkService.findById(id);
    if (entity == null) {
      throw new WebApplicationException("Bookmark with id of " + id + " does not exist.", Status.NOT_FOUND);
    }
    return entity;
  }

  @POST
  @Transactional
  public Response create(@Valid Bookmark item) {
    Bookmark created = bookmarkService.create(item);
    return Response.status(Status.CREATED).entity(created).build();
  }

  @PUT
  @Path("/{id}")
  @Transactional
  public Response update(@PathParam("id") Long id, Bookmark update) {
    Bookmark updated = bookmarkService.update(id, update);
    return  Response.ok(updated).build();
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public Response delete(@PathParam("id") Long id) {
    bookmarkService.delete(id);
    return Response.ok().build();
  }
}
