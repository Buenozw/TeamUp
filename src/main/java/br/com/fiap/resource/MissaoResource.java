package br.com.fiap.resource;

import br.com.fiap.beans.Missao;
import br.com.fiap.bo.MissaoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/missao")
public class MissaoResource {

    private MissaoBO missaoBO = new MissaoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Missao> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Missao>) missaoBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Missao missao, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        missaoBO.inserirBo(missao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(missao.getId_missao()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Missao missao) throws ClassNotFoundException, SQLException {
        missaoBO.atualizarBo(missao);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{idMissao}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("idMissao") int idMissao) throws ClassNotFoundException, SQLException {
        missaoBO.deletarBo(idMissao);
        return Response.ok().build();
    }
}
