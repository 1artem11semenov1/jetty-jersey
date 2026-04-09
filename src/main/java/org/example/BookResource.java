package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.DAO.BookInMemoryDAO;
import org.example.DTO.BookDTO;
import org.example.model.Book;

import java.util.List;
import java.util.stream.Collectors;


@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private static final BookInMemoryDAO bookDAO = new BookInMemoryDAO();

    @GET
    @Path("/all")
    public List<BookDTO> getAll() {
        return bookDAO.getAll().stream()
                .map(BookDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        Book book = bookDAO.getById(id);
        if (book == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Book with id = " + id + " not found.").build();
        }
        return Response.ok(BookDTO.fromEntity(book)).build();
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public BookDTO saveBook(BookDTO book) {
        return BookDTO.fromEntity(bookDAO.create(book.toEntity()));
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") Integer id, BookDTO book) {
        Book toUpdate = book.toEntity();
        toUpdate.setId(id);
        Book bookUpd = bookDAO.update(toUpdate);
        if (bookUpd == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Book with id = " + id + " not found.").build();
        }
        return Response.ok(BookDTO.fromEntity(bookUpd)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteById(@PathParam("id") Integer id) {
        boolean res = bookDAO.delete(id);
        if (!res) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok("Book with id = " + id + " successfully deleted").build();
    }
}
