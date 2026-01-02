package com.home.controller.model;

import com.home.dto.model.request.LeitorRequest;
import com.home.dto.model.response.LeitorResponse;
import com.home.service.model.LeitorService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/leitor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Leitor")
public class LeitorController {

    @Inject
    LeitorService leitorService;

    @POST
    public Response cadastrarLeitor(@Valid LeitorRequest request){
        LeitorResponse response = leitorService.cadastraLeitor(request);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    public LeitorResponse buscarLeitor(@PathParam("id") @Min(1) Long id){
        return leitorService.buscarPorId(id);
    }

    @GET
    public List<LeitorResponse> listarTodosLeitores(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size){
        return leitorService.listarAll(page, size);
    }

    @DELETE
    @Path("/{id}")
    public Response excluirLeitor(@PathParam("id") @Min(1) Long id){
        leitorService.excluirLeitor(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public LeitorResponse atualizarLeitor(@PathParam("id") @Min(1) Long id,
                                        @Valid LeitorRequest request) {
        return leitorService.atualizarLeitor(id, request);
    }
}
