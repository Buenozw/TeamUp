package br.com.fiap.resource;

import br.com.fiap.beans.Conquista;
import br.com.fiap.bo.ConquistaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/conquista")
public class ConquistaResource {

    private ConquistaBO conquistaBO = new ConquistaBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Conquista> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Conquista>) conquistaBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Conquista conquista, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        conquistaBO.inserirBo(conquista);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(conquista.getId_consquista()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Conquista conquista) throws ClassNotFoundException, SQLException {
        conquistaBO.atualizarBo(conquista);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idConquista}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idConquista") int idConquista) throws ClassNotFoundException, SQLException {
        conquistaBO.deletarBo(idConquista);
        return Response.ok().build();
    }
}
