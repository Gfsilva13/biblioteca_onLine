package com.home.controller.model;

import com.home.dto.model.request.EditoraRequest;
import com.home.dto.model.response.EditoraResponse;
import com.home.service.model.EditoraService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/editoras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Editora")
public class EditoraController {

    @Inject
    EditoraService editoraService;

    @POST
    public Response cadastrarEditora(@Valid EditoraRequest request){
        EditoraResponse response = editoraService.cadastrarEditora(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public EditoraResponse buscarEditora(@PathParam("id") @Min(1) Long id){
        return editoraService.buscarPorId(id);
    }

    @GET
    public List<EditoraResponse> listarTodasEditoras(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size){
        return editoraService.listarAll(page, size);
    }

    @DELETE
    @Path("/{id}")
    public Response excluirEditora(@PathParam("id") @Min(1) Long id){
        editoraService.excluirEditora(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public EditoraResponse atualizarEditora(@PathParam("id") @Min(1) Long id,
                                        @Valid EditoraRequest request) {
        return editoraService.atualizarEditora(id, request);
    }
}
