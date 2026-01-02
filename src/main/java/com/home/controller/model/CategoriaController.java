package com.home.controller.model;

import com.home.dto.model.request.CategoriaRequest;
import com.home.dto.model.response.CategoriaResponse;
import com.home.service.model.CategoriaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Categoria Livros")
public class CategoriaController {

    @Inject
    CategoriaService categoriaService;

    @POST
    public Response cadastrarCategoria(@Valid CategoriaRequest request){
        CategoriaResponse response = categoriaService.cadastraCategoria(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public CategoriaResponse buscarCategoria(@PathParam("id") @Min(1) Long id){
        return categoriaService.buscarPorId(id);
    }

    @GET
    public List<CategoriaResponse> listarTodasCategorias(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size){
        return categoriaService.listarAll(page, size);
    }

    @DELETE
    @Path("/{id}")
    public Response excluirCategoria(@PathParam("id") @Min(1) Long id){
        categoriaService.excluirCategoria(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public CategoriaResponse atualizarCategoria(@PathParam("id") @Min(1) Long id,
                                        @Valid CategoriaRequest request) {
        return categoriaService.atualizarCategoria(id, request);
    }
}
