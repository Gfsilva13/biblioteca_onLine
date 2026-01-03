package com.home.controller.model;

import com.home.dto.model.request.LivroRequest;
import com.home.dto.model.response.LivroResponse;
import com.home.service.model.LivroService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Livro")
public class LivroController {

    @Inject
    LivroService livroService;

    @POST
    public Response cadastrarLivro(@Valid LivroRequest request){
        LivroResponse response = livroService.cadastraLivro(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public LivroResponse buscarLivro(@PathParam("id") @Min(1) Long id){
        return livroService.buscarPorId(id);
    }

    @GET
    public List<LivroResponse> listarTodosLivros(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size){
        return livroService.listarAll(page, size);
    }

    @DELETE
    @Path("/{id}")
    public Response excluiLivro(@PathParam("id") @Min(1) Long id){
        livroService.excluirLivro(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public LivroResponse atualizarLivro(@PathParam("id") @Min(1) Long id,
                                        @Valid LivroRequest request) {
        return livroService.atualizarLivro(id, request);
    }
}
