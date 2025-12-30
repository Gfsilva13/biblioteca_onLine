package com.home.controller.model;

import com.home.dto.model.AutorRequest;
import com.home.dto.model.AutorResponse;
import com.home.service.model.AutorService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/autor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Autor")
public class AutorController {

    @Inject
    AutorService autorService;

    @POST
    public Response cadastrarAutor(@Valid AutorRequest request){
        AutorResponse response = autorService.cadastraAutor(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public AutorResponse buscarAutor(@PathParam("id") @Min(1) Long id){
        return autorService.buscarPorId(id);
    }

    @GET
    public List<AutorResponse> listarTodosAutores(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size){
        return autorService.listarAll(page, size);
    }

    @DELETE
    @Path("/{id}")
    public Response excluirAutor(@PathParam("id") @Min(1) Long id){
        autorService.excluirAutor(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public AutorResponse atualizarAutor(@PathParam("id") @Min(1) Long id,
                                        @Valid AutorRequest request) {
        return autorService.atualizarAutor(id, request);
    }
}
